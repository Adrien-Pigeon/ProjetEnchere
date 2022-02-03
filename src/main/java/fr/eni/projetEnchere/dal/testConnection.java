package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

public class testConnection {

	public static void main(String[] args) {
		
		
		
		Connection cnx = null;
		try {
			cnx =  ConnectionProvider.getConnection();
			
			if(cnx != null) {
				System.out.println("connnection OK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

}
