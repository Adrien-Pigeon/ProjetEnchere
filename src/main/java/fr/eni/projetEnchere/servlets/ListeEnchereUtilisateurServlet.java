package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
 * Servlet implementation class ListeEnchereUtilisateurServlet
 */
@WebServlet("/ListeEnchereUtilisateur")
public class ListeEnchereUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeEnchereUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Manager pour aller chercher l'article
		try {

			// Récupération des paramètres
			List<ArticleVendu> articles = new ArrayList<>();
			
			
			// UtilisateurManager um = UtilisateurManager.getInstance();
			ArticleVenduManager am = ArticleVenduManager.getInstance();
			// RetraitManager rm = RetraitManager.getInstanceRetrait();
			Utilisateur utilisateurCo = (Utilisateur) request.getSession().getAttribute("user");
			int num = utilisateurCo.getNoUtilisateur();
			System.out.println(utilisateurCo.getNoUtilisateur());
			

			articles = am.selectArticleByUser(num);
			
			for (ArticleVendu art : articles) {
				System.out.println(art.getNomArticle());
			}

			request.setAttribute("article", articles);

			request.getRequestDispatcher("/accesConnecte/ListeEnchereUtilisateur.jsp").forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace();
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
			
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
