package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.ArticleVenduManager;
import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.ArticleVendu;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recherche = request.getParameter("srecherche");
		int noCategorie = Integer.parseInt(request.getParameter("scategorie"));
		List<ArticleVendu> listeArticles = null;
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		try {
			listeArticles = avm.RechercherParCategorie(noCategorie);
		} catch (DalException | BllException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeArticles", listeArticles);
		
		request.getRequestDispatcher("/").forward(request, response);
	}

}
