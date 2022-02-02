package fr.eni.projetEnchere.helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.projetEnchere.dal.Exception.DalException;

public class DBConnectPool {
	//se connecter
	public static Connection seConnecter() throws DalException {
		Connection cnx = null;
		InitialContext context = null;
		DataSource ds = null;

		//Initialisation du contexte initial
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			throw new DalException("Erreur d'acces au contexte initial", e);
		}

		//Chargement du context via context.xml
		try {
			ds = (DataSource) context.lookup("java:comp/env/jdbc/dsEncheres");
		} catch (NamingException e) {
			throw new DalException("Objet introuvable dans l'annuaire", e);
		}
		//Pool de connexion
		try {
			cnx = ds.getConnection();
		} catch (SQLException e) {
			throw new DalException("Impossible d'obtenir le pool de connection", e);
			
		}
		return cnx;
	}
	//seDeconnecter
	public static void seDeconnecter(Statement stmt, Connection cnx) throws DalException{
		try {
			if (stmt!=null) stmt.close();
		} catch (SQLException e) {
			throw new DalException("Probleme de fermeture du statement",e);
		}

		try {
			if (cnx!=null) cnx.close();
		} catch (SQLException e) {
			throw new DalException("Probleme de fermeture de la connexion",e);
		}

	}
}