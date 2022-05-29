package com.etudiant;



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
public class ListesEtudiants {
	            
				//public Nombreetudiant pave= new Nombreetudiant();
				//public int nbpave = pave.nombrePave();
		
				
		        public List<Etudiant> listeEtud (HttpServletRequest request, HttpServletResponse response) {
			     // Listes Etudiants = new etudiant[nbpave] ;
		        
		        Integer id = Integer.parseInt(request.getParameter("id_chambre"));
		        Integer maxplace = Integer.parseInt(request.getParameter("maxplace"));
		        HttpSession session = request.getSession();
	            session.setAttribute("maxplace",maxplace);
	            session.setAttribute("id_chambre",id);
		        
		        
		        List<Etudiant> etudiants = new ArrayList<Etudiant>();
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
		            resultat = statement.executeQuery( " SELECT * FROM etudiant INNER JOIN reservation ON etudiant.id_etudiant =reservation.id_etudiant  WHERE reservation.id_chambre = "+id+"; ");
		            																
		            /* Récupération des données du résultat de la requête de lecture */
		            while ( resultat.next() ) {
		               
		                /* Formatage des données pour affichage dans la JSP finale. */
		            
		                	Etudiant etudiant = new Etudiant();
		          		   	etudiant.setId_etudiant(resultat.getInt("id_etudiant"));
		          		    etudiant.setNom(resultat.getString("nom"));
		          		    etudiant.setPrenom(resultat.getString("prenom"));
		          		    etudiant.setNiveau(resultat.getString("niveau"));
		          		    etudiant.setEmail(resultat.getString("email"));
		          		    etudiant.setNumcarte(resultat.getString("numcarte"));
		          		    etudiant.setDepartement(resultat.getString("departement"));
		          		   
		          		    etudiants.add(etudiant);
		          		   
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

		        return etudiants;
		    }
		 

		}
		
		
		
		
		
		
		
		
		
