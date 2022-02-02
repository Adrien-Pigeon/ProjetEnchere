package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.helpers.HashPassword;

/**
 * Servlet implementation class CreerUnCompte
 */
@WebServlet("/CreerCompte")
public class CreerUnCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String prenom=request.getParameter("prenom");
		String nom=request.getParameter("nom");
		//String password=HashPassword.hashpassword(request.getParameter("password"));
		String password=  request.getParameter("password");
		String email = request.getParameter("email");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String telephone = request.getParameter("telephone");
		Boolean administrateur = false;
		int credit = 150;
		
		Utilisateur utilisateur = new Utilisateur(username,nom,prenom,email,telephone, rue ,codePostal,ville,password,
				credit,administrateur);
		
		
		
		UtilisateurManager um = UtilisateurManager.getInstance();
		um.addUser(utilisateur);
		response.sendRedirect(request.getContextPath()+"/login");
	}

}
