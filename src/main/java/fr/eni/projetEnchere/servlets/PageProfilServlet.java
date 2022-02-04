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
import fr.eni.projetEnchere.dal.UtilisateurDAO;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class PageProfilServlet
 */
@WebServlet("/PageProfil")
public class PageProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageProfilServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		request.setAttribute("utilisateur", utilisateurCo);
		boolean btnOn = true;
		request.setAttribute("btnOn", btnOn);

		if (request.getSession() != null) {
			// Recupere la session
			
			
			// request.getRequestDispatcher("/AccueilConnecter?get=1").forward(request, response);
				request.getRequestDispatcher("/WEB-INF/jsp/PageProfil.jsp").forward(request, response);
			
		}else {
			
			// Recupere la session
			HttpSession session = request.getSession(); 
			session.invalidate();
			System.out.println("invalided  session");
			 request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
		}
		
	//	request.getRequestDispatcher("/WEB-INF/jsp/PageProfil.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean btnOn = false;
		// recupération du parametre pseudo envoyé par la jsp
		String pseudo = request.getParameter("pseudo");
		UtilisateurManager um = UtilisateurManager.getInstance();
		Utilisateur utilisateur = um.afficherProfil(pseudo);
		request.setAttribute("utilisateur", utilisateur);
		// verification que l'utilisateur en session n'est pas le meme que le profil à
		// afficher
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		if (utilisateurCo != null) {
			// si ce sont les même alors affichage du bouton modifié
			if (pseudo.equals(utilisateurCo.getPseudo())) {
				btnOn = true;
				request.setAttribute("btnOn", btnOn);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profilUtilisateur.jsp").forward(request,
						response);
			} else { // sinon pas de bouton modifier
				request.setAttribute("btnOn", btnOn);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profilUtilisateur.jsp").forward(request,
						response);
			}
		} else { // Si pas d'utilisateur en session alors affichage du profil
			request.setAttribute("btnOn", btnOn);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profilUtilisateur.jsp").forward(request,
					response);
		}
	}
}
