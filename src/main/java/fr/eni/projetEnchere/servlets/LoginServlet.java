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
import fr.eni.projetEnchere.helpers.HashPassword;



	/**
	 * Servlet implementation class LoginServlet
	 */
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

		/**
	 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			
		}

		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			Utilisateur user= new Utilisateur();
			user.setEmail(username);
			user.setMotDePasse(HashPassword.hashpassword(password));
			UtilisateurManager um = UtilisateurManager.getInstance();
			if(um.login(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				response.sendRedirect(request.getContextPath()+"/WEB-INF/jsp/Accueil.jsp");
			}else {
				request.setAttribute("error", "azerty");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}

	}



