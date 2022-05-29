package com.pavillon;
import java.util.ArrayList;
import java.util.List;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class ListerPavillon {
	            
				//public NombrePavillon pave= new NombrePavillon();
				//public int nbpave = pave.nombrePave();
		
				
		        public List<Pavillon> listesPave () {
			   // Listes pavillons = new Pavillon[nbpave] ;
		        List<Pavillon> pavillons = new ArrayList<Pavillon>();
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
		            resultat = statement.executeQuery( "SELECT * FROM pavillon;" );
		          
		            /* Récupération des données du résultat de la requête de lecture */
		            while ( resultat.next() ) {
		               
		                /* Formatage des données pour affichage dans la JSP finale. */
		                
		                	Pavillon pave = new Pavillon();
		          		   	pave.setId_pavillon(resultat.getInt("id_pavillon"));
		          		    pave.setNompavillon(resultat.getString("nompavillon"));
		          		    
		          		    
		          		    pavillons.add(pave);
		          		   
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

		        return pavillons;
		    }
		 

		}
		
		
		
		
		
		
		
		
		
