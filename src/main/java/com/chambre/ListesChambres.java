package com.chambre;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class ListesChambres {
	            
				//public Nombrechambre pave= new Nombrechambre();
				//public int nbpave = pave.nombrePave();
		
				
		        public List<Chambre> listesChambre (HttpServletRequest request, HttpServletResponse response) {
			     // Listes chambres = new Chambre[nbpave] ;
		        
		        Integer id = Integer.parseInt(request.getParameter("id_pavillon"));
		        HttpSession session = request.getSession();
	            session.setAttribute("id_pavillon",id);
		        
		        
		        List<Chambre> chambres = new ArrayList<Chambre>();
		        /* Chargement du driver JDBC pour MySQL */
		        try {

		            Class.forName( "com.mysql.jdbc.Driver" );
		        } catch ( ClassNotFoundException e ) {
		        }

		        /* Connexion à la base de données */
		        String url = "jdbc:mysql://localhost:3306/msi";
		        String utilisateur = "root";
		        String motDePasse = "";
		        Connection connexion = null;
		        Statement statement = null;
		        ResultSet resultat = null;
		        try {
		            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

		            /* Création de l'objet gérant les requêtes */
		            statement = (Statement) connexion.createStatement();

		            /* Exécution d'une requête de lecture */
		            resultat = statement.executeQuery(  " SELECT * FROM chambre INNER JOIN pavillon ON chambre.id_pavillon = pavillon.id_pavillon  WHERE chambre.id_pavillon = "+id+"; ");
		          
		            /* Récupération des données du résultat de la requête de lecture */
		            while ( resultat.next() ) {
		               
		                /* Formatage des données pour affichage dans la JSP finale. */
		                
		                	Chambre chambre = new Chambre();
		          		   	chambre.setId_chambre(resultat.getInt("id_chambre"));
		          		    chambre.setNomchambre(resultat.getString("nomchambre"));
		          		    chambre.setId_pavillon(id);
		          		    chambre.setMaxplace(resultat.getInt("maxplace"));
		          		   
		          		    
		          		    
		          		    chambres.add(chambre);
		          		   
		            }
		            //request.setAttribute("etudiant", etudiant);
		        } catch ( SQLException e ) {
		        } finally {
		          
		            if ( resultat != null ) {
		                try {
		                    resultat.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		            if ( statement != null ) {
		                try {
		                    statement.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		            if ( connexion != null ) {
		                try {
		                    connexion.close();
		                } catch ( SQLException ignore ) {
		                }
		            }
		        }

		        return chambres;
		    }
		 

		}
		
		
		
		
		
		
		
		
		
