package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/login")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (request.getParameter("login").equalsIgnoreCase("1")) {
//			doGet(request, response);
//		}
		String username =  request.getParameter("pseudo");
		String password =  request.getParameter("password");
		
		Utilisateur user= new Utilisateur();
		
		user.setPseudo(username);
		user.setMotDePasse(HashPassword.hashpassword(password));
		
		UtilisateurManager um = UtilisateurManager.getInstance();
		
		
			try {
				user=um.login(user);
			} catch (BllException | DalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if (user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// request.getRequestDispatcher("/AccueilConnecter?get=1").forward(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecter.jsp").forward(request, response);
			System.out.println("Connecter");
		}else {
			System.out.println("Pas Connecter");
			request.setAttribute("error", "azerty");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			// request.getRequestDispatcher("/login?get=1").forward(request, response);
					}

	}
}
