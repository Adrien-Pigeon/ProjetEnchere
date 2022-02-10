
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
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;

/**
 * Servlet implementation class AccueilConnecter
 */
@WebServlet("/AccueilConnecter")
public class AccueilConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecter.jsp").forward(request, response);
		
		List<ArticleVendu> listeArticles = null;
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		try {
			listeArticles = avm.allArticle();
		} catch (DalException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("listeArticles", listeArticles);
		CategorieManager cm = CategorieManager.getInstance();
		try {
			List<Categorie> categories = cm.lister();

			request.setAttribute("categories", categories);

			
		} catch (DalException e) {
			
			e.printStackTrace();
		}
		if (request.getSession() != null) {

			request.getSession();
			
			request.getRequestDispatcher("/accesConnecte/AccueilConnecter.jsp").forward(request, response);
			

		} else {

			// Recupere la session
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("déconnecté");
			request.getRequestDispatcher("/").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
