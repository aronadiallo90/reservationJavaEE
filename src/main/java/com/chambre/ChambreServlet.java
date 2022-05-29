package com.chambre;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reserver.VerifierReservation;


/**
 * Servlet implementation class ChambreServlet
 */
@WebServlet("/ChambreServlet")
public class ChambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public static final String VUE = "/WEB-INF/listeschambre.jsp";
    public ChambreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        ListesChambres liste = new ListesChambres();
		
		List<Chambre> chambres = liste.listesChambre(request, response);
		request.setAttribute("chambres",chambres);
		
		HttpSession session = request.getSession();
		session.setAttribute("chambres",chambres);
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
