package com.authentification;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etudiant.Etudiant;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class AuthentificationForm {


	 public boolean verifier ( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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

	            /* Création de l'objet gérant les requêtes */
	            statement = (Statement) connexion.createStatement();

	            /* Exécution d'une requête de lecture */
	            resultat = statement.executeQuery( "SELECT * FROM etudiant;" );
	            /* Récupération des données du résultat de la requête de lecture */
	            while ( resultat.next() ) {
	                int id_etudiant = resultat.getInt( "id_etudiant" );
	                String numcarte = resultat.getString( "numcarte" );
	                /* Formatage des données pour affichage dans la JSP finale. */
	                
	                if(numcarte.equals(request.getParameter("numcarte"))){
	           		 
	          		    messages = true;
	          		    Etudiant etudiant = new Etudiant();
	          		    etudiant.setId_etudiant(id_etudiant);
	          		    etudiant.setNumcarte(numcarte);
	          		    etudiant.setNom(resultat.getString("nom"));
	          		    etudiant.setPrenom(resultat.getNString("prenom"));
	          		    etudiant.setDepartement(resultat.getString("departement"));
	          		    etudiant.setNiveau(resultat.getString("niveau"));
	          		    request.setAttribute("etudiant", etudiant);
	          		    
	          		
	          		  }
	          		  else{
	         
	          		  }
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

	        return messages;
	    }

	
}
