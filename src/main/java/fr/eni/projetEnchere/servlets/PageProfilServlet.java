package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		request.setAttribute("utilisateur", utilisateurCo);
		boolean btnOn = true;
		request.setAttribute("btnOn", btnOn);

		request.getRequestDispatcher("/WEB-INF/jsp/PageProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean btnOn = false;
		// recupération du pseudo envoyé par la jsp
		String pseudo = request.getParameter("pseudo");
		// chargement du profil demandé dans la requete
		try {
			Utilisateur utilisateur = UtilisateurDAO.selectByPseudo(pseudo);
			request.setAttribute("utilisateur", utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e);
			getServletContext().getRequestDispatcher("/WEB-INF/erreur/erreur.jsp").forward(request, response);
		}
		// verification que l'utilisateur en session n'est pas le meme que le profil à
		// afficher
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
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
