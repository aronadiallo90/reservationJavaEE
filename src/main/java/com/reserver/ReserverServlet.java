package com.reserver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etudiant.Etudiant;

/**
 * Servlet implementation class ReserverServlet
 */
@WebServlet("/ReserverServlet")
public class ReserverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		request.setAttribute("numcarte",session.getAttribute("numcarte"));
		request.setAttribute("id_etudiant",((Etudiant) session.getAttribute("etudiant")).getId_etudiant());
		
		request.setAttribute("id_chambre",session.getAttribute("id_chambre"));
		int maxplace = (int) session.getAttribute("maxplace");
		VerifierReservation verifi = new VerifierReservation();
		if( verifi.verifierSireservation(request, response) == false) {
		int place = verifi.nombreDeplace(request, response);
		if(place<maxplace) {
			
			verifi.reserver(request, response);
			 session.invalidate();
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
		}
		else {response.getWriter().append("Nombre de place max atteint ").append(request.getContextPath());
		

		}
		
		}else {
			
			response.getWriter().append("Vous avez deja reserver ").append(request.getContextPath());		
			
		
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
