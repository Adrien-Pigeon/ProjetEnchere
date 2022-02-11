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
import fr.eni.projetEnchere.dal.Exception.DalException;
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
		// Recuperation des renseignements de l'utilisateur
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom").trim().toLowerCase();
		String nom = request.getParameter("nom").toLowerCase();
		// String password=HashPassword.hashpassword(request.getParameter("password").trim());
		String password = request.getParameter("password");
		String email = request.getParameter("email").toLowerCase();
		String ville = request.getParameter("ville").toLowerCase();
		String rue = request.getParameter("rue").toLowerCase();
		String codePostal = request.getParameter("codePostal");
		String telephone = request.getParameter("telephone");
		String passwordConf = request.getParameter("password_conf");

		// Creation d'une instance de type Utilisateur
		Utilisateur utilisateur = new Utilisateur();

		// hydratation des attributs de l'objet par le biais des accesseurs
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

		// Creation d'une instance du manager pour appeler les méthodes de la couche Bll
		UtilisateurManager um = UtilisateurManager.getInstance();
		// appel de la methode si les mots de passe sont identiques
		if (password.equals(passwordConf)) {

			try {
				um.addUser(utilisateur);
				// retour vers l'accueil
				this.getServletContext().getRequestDispatcher("/").forward(request, response);
			} catch (BllException e) {
				String erreur = e.getMessage() + ", reessayer.";
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			}
			// Dans le cas contraire un message d'erreur est envoyé
			catch (DalException e) {
				String erreur = "Veuillez réessayer,ce pseudo est déjà utilisé";
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			}
		} else {

			String erreur = "Veuillez réessayer,les mots de passent ne sont pas identiques";
			request.setAttribute("erreur", erreur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}

	}

}
