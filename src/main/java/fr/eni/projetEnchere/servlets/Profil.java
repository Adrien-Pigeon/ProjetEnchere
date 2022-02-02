package fr.eni.projetEnchere.servlets;


	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bo.Utilisateur;



	/**
	 * Servlet implementation class MyAccountServlet
	 */
	@WebServlet("/mon-compte")
	public class MyAccountServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			boolean isConnected = true;
			if(session!=null) {			
	 			Utilisateur user = (Utilisateur) session.getAttribute("user");
				if(user==null) {
					isConnected = false;
				}else {				
					response.getWriter().append("Bonjour "+user.getPrenom());
				}
			}else {
				isConnected = false;
			}
			if(!isConnected) {
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}

	}



