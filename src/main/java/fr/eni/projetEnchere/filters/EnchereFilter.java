package fr.eni.projetEnchere.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EnchereFilter
 */
@WebFilter("/EnchereFilter")
public class EnchereFilter implements Filter {

 
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//Cast des objets request et response
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//recuperation de la session
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			//redirection vers la page d'accueil
			request.getRequestDispatcher("/WEB-INF/AccueilNonConnecter.jsp").forward(request, response);
		}else {
			//affichage de la page restreinte
			chain.doFilter(request, response);
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
