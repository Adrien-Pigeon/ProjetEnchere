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
 * Servlet implementation class MonProfil
 */
@WebServlet("/MonProfil")
public class MonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro = request.getParameter("profil");
		System.out.println(pro);
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		int id = utilisateurCo.getNoUtilisateur();
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			utilisateurCo = um.SelectUser(id);
		} catch (DalException e) {
			
			System.err.println(e.getMessage());
		}
		request.setAttribute("utilisateur", utilisateurCo);
		request.setAttribute("utilisateurCo", utilisateurCo);
		boolean btnOn = true;
		request.setAttribute("btnOn", btnOn);

		if (request.getSession() != null) {
			// Recupere la session
			
			
			request.getRequestDispatcher("/WEB-INF/jsp/PageProfil.jsp").forward(request, response);
			
		}else {
			
			// Recupere la session
			HttpSession session = request.getSession(); 
			session.invalidate();
			System.out.println("invalided  session");
			 request.getRequestDispatcher("/ProjetEnchere").forward(request, response);
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
