package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bll.UtilisateurManager;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieDAO;
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

		request.setCharacterEncoding("UTF-8");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		UtilisateurManager um = UtilisateurManager.getInstance();
		
		//Attributs articles
		String nomArticle = request.getParameter("nom");
		String description = request.getParameter("description");
		String categorie = request.getParameter("scategorie");
		String prix = request.getParameter("prixInitial");
		String debutVente = request.getParameter("dateDebut");
		String finVente = request.getParameter("dateFin");
		
		try {
			Date dateDebut = dateFormat.parse(debutVente);
			Date dateFin = dateFormat.parse(finVente);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		//Attributs retrait
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		
		
		
		
		
		
		String message;
		if (request.getParameter("sarticle").trim().isEmpty()) {
			message = "Erreur - Veuillez renseigner un article.";
			request.setAttribute("erreur", message);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/nouvelleEnchere.jsp").forward(request,
					response);
		}
	}

}
