package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.ArticleVenduManager;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bll.RetraitManager;
import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;

import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/VendArticle")
public class VendArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VendArticleServlet() {
		super();

	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//recupere les informations de l'utilisateur
		Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
		request.setAttribute("utilisateur", utilisateurCo);
		CategorieManager cm = CategorieManager.getInstance();
		try {
			List<Categorie> categories = cm.lister();

			request.setAttribute("categories", categories);

		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (request.getSession() != null) {

			// Recupere la session
			request.getRequestDispatcher("/accesConnecte/VendreArticle.jsp").forward(request, response);

		} else {

			// Recupere la session
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("/").forward(request, response);
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
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			utilisateurCo = um.SelectUser(id);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		
		//Attributs articles
		String nomArticle = request.getParameter("nom").trim().toLowerCase();
		String description = request.getParameter("description").trim().toLowerCase();
		int noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		int prix = Integer.parseInt(request.getParameter("prixInitial"));
		String debutVente = request.getParameter("dateDebut");
		String finVente = request.getParameter("dateFin");
		
		
		CategorieManager cm = CategorieManager.getInstance();
		Categorie categorie=null;
		try {
			categorie = cm.selectParId(noCategorie);
			
		} catch (BllException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate dateDebut =null;
		LocalDate dateFin = null;
		dateDebut = LocalDate.parse(debutVente, formatter);
		dateFin = LocalDate.parse(finVente, formatter);
		
		ArticleVendu article = new ArticleVendu();
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setCategorie(categorie);
		article.setPrixInitial(prix);
		article.setPrixVente(prix);
		article.setDateDebutEncheres(dateDebut);
		article.setDateFinEncheres(dateFin);
		article.setUtilisateur(utilisateurCo);
		ArticleVenduManager am = ArticleVenduManager.getInstance();
		try {
			am.ajouterArticle(article);
		} catch (DalException e1) {
			e1.getMessage();
			e1.printStackTrace();
		} catch (BllException e) {
			System.err.println(e.getMessage());
		}
		
		//Attributs retrait
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		RetraitManager rm = RetraitManager.getInstanceRetrait();
		Retrait lieuRetrait = new Retrait();
		
		lieuRetrait.setRue(rue);
		lieuRetrait.setVille(ville);
		lieuRetrait.setCodePostal(codePostal);
		lieuRetrait.setArticle(article);
		
		try {
			rm.ajouterRetrait(lieuRetrait);
		} catch (BllException e) {
			System.err.println(e.getMessage());
		} catch (DalException e) {
			
			e.printStackTrace();
		}
		

		this.getServletContext().getRequestDispatcher("/AccueilConnecter").forward(request,
				response);
	}

}
