package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.ArticleVenduManager;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class RechercherArticle
 */
@WebServlet("/Rechercher")
public class RechercherArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String motRecherche = request.getParameter("srecherche");
		int noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		
		if(noCategorie == 150 && motRecherche.isBlank()) {
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.allArticle();
			} catch (DalException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		//Recherche par categorie
		else if(noCategorie != 0 && motRecherche.isBlank()) {
		List<ArticleVendu> listeArticles = null;
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		try {
			listeArticles = avm.RechercherParCategorie(noCategorie);
		} catch (DalException | BllException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("listeArticles", listeArticles);
		}
		//Recherche par filtre nom
		else if(motRecherche != null && noCategorie == 0) {
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.RechercherParNom(motRecherche);
			} catch (DalException | BllException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		//recherche par deux filtres
		else if(motRecherche != null && noCategorie != 0){
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.rechercheDouble(motRecherche,noCategorie);
			} catch (DalException | BllException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		CategorieManager cm = CategorieManager.getInstance();
		try {
			List<Categorie> categories = cm.lister();

			request.setAttribute("categories", categories);

			
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String motRecherche = request.getParameter("srecherche");
		int noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		
		//Afficher tous les articles
		if(noCategorie == 150 && motRecherche.isBlank()) {
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.allArticle();
			} catch (DalException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		//Recherche par categorie
		else if(noCategorie != 0 && motRecherche.isBlank()) {
			
		List<ArticleVendu> listeArticles = null;
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		try {
			listeArticles = avm.RechercherParCategorie(noCategorie);
		} catch (DalException | BllException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("listeArticles", listeArticles);
		}
		//Recherche par filtre nom
		else if(motRecherche != null && noCategorie == 0) {
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.RechercherParNom(motRecherche);
			} catch (DalException | BllException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		//recherche par deux filtres
		else if(motRecherche != null && noCategorie != 0){
			List<ArticleVendu> listeArticles = null;
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			try {
				listeArticles = avm.rechercheDouble(motRecherche,noCategorie);
			} catch (DalException | BllException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticles);
		}
		CategorieManager cm = CategorieManager.getInstance();
		try {
			List<Categorie> categories = cm.lister();

			request.setAttribute("categories", categories);

			
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
		
		request.getRequestDispatcher("/accesConnecte/AccueilConnecter.jsp").forward(request, response);
		
	}

}
