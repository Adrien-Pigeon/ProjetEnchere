package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.helpers.HashPassword;

/**
 * Servlet implementation class CreerUnCompte
 */
@WebServlet("/CreerCompte")
public class CreerUnCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		// String password=HashPassword.hashpassword(request.getParameter("password"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String ville = request.getParameter("ville");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String telephone = request.getParameter("telephone");
		String passwordConf = request.getParameter("password_conf");

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setRue(rue);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(password);
		utilisateur.setCredit(150);
		utilisateur.setAdministrateur(false);
		System.out.println(utilisateur.toString());

		UtilisateurManager um = UtilisateurManager.getInstance();
		if (password.equals(passwordConf)) {
			
			try {
				um.addUser(utilisateur);
				response.sendRedirect("/WEB-INF/jsp/AccueilNonConnecter.jsp");
				//request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
			} catch (BllException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String erreur = "les mots de passent ne sont pas identiques";
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("/WEB-INF/jsp/erreur.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

}
