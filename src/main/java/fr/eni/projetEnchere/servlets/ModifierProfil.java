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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession() == null) {
			// Recupere la session
			
			System.out.println("valided session");
			// request.getRequestDispatcher("/AccueilConnecter?get=1").forward(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp").forward(request, response);			
			
			
		}else {
			
			// Recupere la session
			HttpSession session = request.getSession(); 
			session.invalidate();
			System.out.println("invalided  session");
			 request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		request.setAttribute("utilisateur", utilisateurCo);
		String password = request.getParameter("password").trim();
		String pseudo = request.getParameter("pseudo").trim();
		String prenom = request.getParameter("prenom").trim().toLowerCase();
		String nom = request.getParameter("nom").trim().toLowerCase();
		// String password=HashPassword.hashpassword(request.getParameter("password"));
		String email = request.getParameter("email").trim().toLowerCase();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String codePostal = request.getParameter("codePostal").trim();
		String telephone = request.getParameter("telephone").trim();
		String passwordConf = request.getParameter("password_conf").trim();
		String nouveauMotDePasse = request.getParameter("password_conf").trim();
		
		if(password.equals(utilisateurCo.getMotDePasse())) {
			Utilisateur utilisateur = new Utilisateur();
			
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setRue(rue);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(nouveauMotDePasse);
			utilisateur.setCredit(150);
			utilisateur.setAdministrateur(false);
			

			if (nouveauMotDePasse.equals(passwordConf)) {
			
			UtilisateurManager um = UtilisateurManager.getInstance();
			um.modifierUser(utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp").forward(request, response);
			}else {
				
			}
				
			
			
			
		}
	}

}
