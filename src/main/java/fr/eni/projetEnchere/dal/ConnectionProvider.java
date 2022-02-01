package fr.eni.projetEnchere.dal;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionProvider {
	
	private static DataSource dataSource;

	static {// init		
		// chargement de context
		Context context;
		try {
			context = new InitialContext();
			// creation de pool
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/cnx_pool");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection() throws SQLException {
		// obtenir la cnx		
		return dataSource.getConnection();
	} 
	

}
