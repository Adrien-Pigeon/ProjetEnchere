package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;
import fr.eni.projetEnchere.helpers.HashPassword;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récuperation des parametres du formulaire
		String username = request.getParameter("login");
		String password = request.getParameter("password");

		// j'instancie un objet de type Utilisateur et j'hydrate les attributs
		// login et pwd
		Utilisateur user = new Utilisateur();

		if (username.contains("@")) {
			user.setEmail(username);
		} else {
			user.setPseudo(username);
		}
		user.setMotDePasse(password);

		// j'instancie un objet de type UtilisateurManager s'il existe
		UtilisateurManager um = UtilisateurManager.getInstance();

		try {
			user = um.login(user);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println(user);

		if (user != null) {
			// Recupere la session
			HttpSession session = request.getSession();
			// Recupere l'utilisateur
			session.setAttribute("user", user);
			
	
			Cookie[] cookies = request.getCookies();

			// Creation du cookie
			Cookie C = new Cookie("login", username);

			// definition de la limite de validité
			C.setMaxAge(180);

			// envoi du cookie dans la reponse HTTP
			response.addCookie(C);

			request.getRequestDispatcher("/AccueilConnecter").forward(request, response);
			
			
		} else {

			System.out.println("Pas Connecter");

			request.setAttribute("error", "azerty");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

		}

		
		
		

		

	}

}
