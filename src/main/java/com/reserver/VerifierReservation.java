package com.reserver;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chambre.Chambre;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class VerifierReservation {

	
	
	 public boolean verifierSireservation ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		         boolean messages = false;
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
		            int id = (int) request.getAttribute("id_etudiant");
		            /* Création de l'objet gérant les requêtes */
		            statement = (Statement) connexion.createStatement();

		            /* Exécution d'une requête de lecture */
		            resultat = statement.executeQuery(" SELECT * FROM etudiant INNER JOIN reservation ON etudiant.id_etudiant = reservation.id_etudiant  WHERE reservation.id_etudiant = "+id+"; ");
		            /* Récupération des données du résultat de la requête de lecture */
		              if(resultat.next()) {
		            	  return true;
		              }else {
		            	  return false;
		              }
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
		        return   messages;
		  
		    }
	
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean afficherreservation ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			boolean messages = false;
     
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
            int id = (int) request.getAttribute("id_etudiant");
            /* Création de l'objet gérant les requêtes */
            statement = (Statement) connexion.createStatement();

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery(" SELECT * FROM chambre INNER JOIN reservation ON reservation.id_chambre = chambre.id_chambre  WHERE chambre.id_etudiant = "+id+"; ");
            /* Récupération des données du résultat de la requête de lecture */
              if(resultat.next()) {
            	//request.setAttribute("chambre",resultat.getString("nomchambre"));
            	 return true; 
              }else {
            	  return false;
              }
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
        return   messages;
  
    }


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public int nombreDeplace ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

			
			
			int id = (Integer) request.getAttribute("id_chambre");
		
			
			
			
		     int messages = 0;
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
		            resultat = statement.executeQuery(" SELECT * FROM etudiant INNER JOIN reservation ON etudiant.id_etudiant = reservation.id_etudiant  WHERE reservation.id_chambre = "+id+"; " );
		            /* Récupération des données du résultat de la requête de lecture */
		       
		            resultat.last();
		            int nombreplace = resultat.getRow();
		       
		            resultat.beforeFirst();
		            messages = nombreplace;
		            
		            
		            
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

		        return messages;
		    }
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean reserver ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		  boolean messages = false;
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
		        
		        
		        
		        HttpSession session = request.getSession();
       	        int  id_etudiant = (Integer) session.getAttribute("id_etudiant"); 
       	        int id_chambre = (Integer) session.getAttribute("id_chambre");
       	        
       	        try {
		            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

		            /* Création de l'objet gérant les requêtes */
		            statement = (Statement) connexion.createStatement();

		            /* Exécution d'une requête de lecture */
		            
		            PreparedStatement ps = (PreparedStatement) connexion.prepareStatement( "INSERT INTO reservation (id_reservation, id_chambre, id_etudiant, datereservation) VALUES(NULL, ?, ?, NOW());" );
		            ps.setInt( 1, id_chambre );
	        	    ps.setInt( 2, id_etudiant );
	        	    ps.executeUpdate();
	        	    messages = true;
		            
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

		        return messages;
		    }
	
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean annulerReserver ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		  boolean messages = false;
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
		        
		        
		        
		        HttpSession session = request.getSession();
      	        int  id_etudiant = (Integer) session.getAttribute("id_etudiant"); 
      	        try {
		            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

		            /* Création de l'objet gérant les requêtes */
		            statement = (Statement) connexion.createStatement();

		            /* Exécution d'une requête de lecture */
		            
		            PreparedStatement ps = (PreparedStatement) connexion.prepareStatement( "DELETE FROM reservation WHERE reservation.id_etudiant = ? ;" );
		           
	        	    ps.setInt( 1, id_etudiant );
	        	    ps.executeUpdate();
	        	    messages = true;
		            
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

		        return messages;
		    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
}
