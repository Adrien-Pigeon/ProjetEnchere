package fr.eni.projetEnchere.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Utilisateur;

 
public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	private final static String INSERT_USER = "INSERT INTO users (prenom,nom,username,password) VALUES(?,?,?,?)"; 
	private final static String SELECT_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
	
	public void insert(Utilisateur user) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT_USER);
			stmt.setString(1, user.getPrenom());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
			stmt.executeUpdate();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean selectByLogin(Utilisateur user) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(SELECT_LOGIN);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet result =  stmt.executeQuery();
			if(result.next()) {
				user.setNoUtilisateur(result.getInt("id"));
				user.setNom(result.getString("nom"));
				user.setPrenom(result.getString("prenom"));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
