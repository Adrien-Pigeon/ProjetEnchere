package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class SuppimerUtilisateurServlet
 */
@WebServlet("/SupprimerProfil")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager um = UtilisateurManager.getInstance();
		HttpSession session = request.getSession();
		
			Utilisateur no_utilisateur = (Utilisateur) session.getAttribute("no_utilisateur");
		
		// SUPPRESSION DU COMPTE
		try {
			um.delete(no_utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
		}
		
		// DECONNEXION 
		String logged = null;
		session.setAttribute("logged", logged);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}