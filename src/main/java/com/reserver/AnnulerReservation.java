package com.reserver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class AnnulerReservation
 */
@WebServlet("/AnnulerReservation")
public class AnnulerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        
        request.setAttribute("id_etudiant",session.getAttribute("id_etudiant"));
        request.setAttribute("etudiant", session.getAttribute("etudiant"));	                	                
						
		
		VerifierReservation verifi = new VerifierReservation();
		  if(verifi.verifierSireservation( request, response )) {
			
			if(verifi.annulerReserver(request,response)) {
				 session.invalidate();
				 response.sendRedirect("/reservation/ConnexionServlet");
				
			}else {
				
				//this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward( request, response );
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
