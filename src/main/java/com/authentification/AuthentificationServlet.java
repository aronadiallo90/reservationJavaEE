package com.authentification;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etudiant.Etudiant;
import com.pavillon.ListerPavillon;
import com.pavillon.Pavillon;
import com.reserver.VerifierReservation;
@WebServlet("/index")
public class AuthentificationServlet extends HttpServlet {

	 /**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
	    public static final String ATT_USER = "utilisateur";
	    public static final String ATT_FORM = "form";
	    public static final String VUE = "/WEB-INF/index.jsp";
	    
			
	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Affichage de la page d'inscription */
	       // this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
             AuthentificationForm form = new AuthentificationForm();
			
	        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
	        try {
				if(form.verifier( request, response )) {
					Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
					HttpSession session = request.getSession();
	                session.setAttribute("etudiant",etudiant);
	                session.setAttribute("id_etudiant",etudiant.getId_etudiant());
	                request.setAttribute("id_etudiant",etudiant.getId_etudiant());
	                request.setAttribute("etudiant", etudiant);	                	                
					ListerPavillon pav = new ListerPavillon();					
					List<Pavillon> pavillons = pav.listesPave();
					request.setAttribute("pavillons",pavillons);
					session.setAttribute("pavillons",pavillons);
                    VerifierReservation verifi = new VerifierReservation();
					
					if( verifi.verifierSireservation(request, response) == true) {
						 session.setAttribute("reserver",verifi.verifierSireservation(request, response));
						}	
					if( verifi.afficherreservation(request, response) == true) {
						 session.setAttribute("chreserver",verifi.afficherreservation(request, response));
						
						}
					this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
					 
					
				} else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Préparation de l'objet formulaire */
	        
	        /* Stockage du formulaire et du bean dans l'objet request */
	        
	       
	        doGet(request, response);
	        
	    }
	
}
