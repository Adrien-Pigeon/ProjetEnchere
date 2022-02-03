package fr.eni.projetEnchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccueilConnecter
 */
@WebServlet("/AccueilConnecter")
public class AccueilConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilConnecterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecter.jsp").forward(request, response);
	
	
		if (request.getSession() == null) {
			// Recupere la session
			
			
			// request.getRequestDispatcher("/AccueilConnecter?get=1").forward(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecter.jsp").forward(request, response);
			System.out.println("valided session");
			
		}else {
			
			// Recupere la session
			HttpSession session = request.getSession(); 
			session.invalidate();
			System.out.println("invalide la session");
			 request.getRequestDispatcher("/WEB-INF/jsp/AccueilNonConnecter.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
