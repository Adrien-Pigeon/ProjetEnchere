package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if (request.getSession() != null) {
//			// Recupere la session
//			
//			System.out.println("valided  session");
//
//			// request.getRequestDispatcher("/AccueilConnecter?get=1").forward(request, response);
			request.getRequestDispatcher("/accesConnecte/VendreArticle.jsp").forward(request, response);			
//			System.out.println("valided session");
//			
		}else {
//			
//			// Recupere la session
			HttpSession session = request.getSession(); 
			session.invalidate();
//			System.out.println("invalided  session");
			 request.getRequestDispatcher("/").forward(request, response);
	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message;
		
		if (request.getParameter( "sarticle" ).trim().isEmpty() ) {
			message = "Erreur - Veuillez renseigner un article.";
			request.setAttribute("erreur", message);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/nouvelleEnchere.jsp" ).forward( request, response );
		}
	}

}
