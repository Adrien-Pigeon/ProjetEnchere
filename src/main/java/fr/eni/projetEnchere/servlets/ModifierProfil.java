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
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession() != null) {
			// Recuperer la session
			Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
			request.setAttribute("utilisateur", utilisateurCo);
			request.getRequestDispatcher("/accesConnecte/ModifierProfil.jsp").forward(request, response);

		} else {

//			// Recuperer la session
//			HttpSession session = request.getSession(); 
			Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
			request.setAttribute("utilisateur", utilisateurCo);
			// Fermer la session
			request.getSession().invalidate();
			System.out.println("déconnecté");
			request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		int id = utilisateurCo.getNoUtilisateur();
		// String oldPseudo = utilisateurCo.getPseudo();
		request.setAttribute("utilisateur", utilisateurCo);
		String nom = request.getParameter("nom").trim().toLowerCase();
		String password = request.getParameter("password").trim();
		String pseudo = request.getParameter("pseudo").trim();
		String prenom = request.getParameter("prenom").trim().toLowerCase();

		// String password=HashPassword.hashpassword(request.getParameter("password"));
		String email = request.getParameter("email").trim().toLowerCase();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String codePostal = request.getParameter("codePostal").trim();
		String telephone = request.getParameter("telephone").trim();
		String passwordConf = request.getParameter("password_conf").trim();
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse").trim();

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setNoUtilisateur(id);
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setRue(rue);
		utilisateur.setVille(ville);
		if (nouveauMotDePasse == null || nouveauMotDePasse.isBlank()) {
			utilisateur.setMotDePasse(password);

		} else {
			if (nouveauMotDePasse.equals(passwordConf)) {
				utilisateur.setMotDePasse(nouveauMotDePasse);
			} else {
				String erreur = "les mots de passent ne sont pas identiques";
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/erreur.jsp").forward(request, response);
			}
		}

		utilisateur.setCredit(150);
		utilisateur.setAdministrateur(false);

		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			um.modifierUser(utilisateur);
			request.setAttribute("btnOn", true);
			request.setAttribute("utilisateur", utilisateur);

		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/PageProfil.jsp").forward(request, response);

		// }
	}

}
