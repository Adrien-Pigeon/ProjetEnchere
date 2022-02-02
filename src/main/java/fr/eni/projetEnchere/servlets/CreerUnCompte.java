package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.helpers.HashPassword;

/**
 * Servlet implementation class CreerUnCompte
 */
@WebServlet("/CreerCompte")
public class CreerUnCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String prenom=request.getParameter("prenom");
		String nom=request.getParameter("nom");
		String password=HashPassword.hashpassword(request.getParameter("password"));
		
		UtilisateurManager um = UtilisateurManager.getInstance();
		um.addUser(prenom, nom, username, password);
		response.sendRedirect(request.getContextPath()+"/login");
	}

}
