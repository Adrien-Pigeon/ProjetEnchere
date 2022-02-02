package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;
import fr.eni.projetEnchere.helpers.DBConnectPool;

public class CategorieDAO {

	private final static String LISTER ="SELECT *FROM CATEGORIES;";
	private final static String INSERER ="INSERT INTO CATEGORIES (libelle) values (?);";
	// private final static String SUPPRIMER = "delete from CATEGORIES where libelle =?;";
	// private final static String MODIFIER = "update CATEGORIES set libelle = ?";
	private final static String SELECTBY = "select no_categorie, libelle from CATEGORIES where libelle = ?;";
	private final static String SELECTBYID = "select no_categorie, libelle from CATEGORIES where no_categorie = ?;";


	public static ArrayList<Categorie> lister() throws DalException{
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		
		ArrayList<Categorie> listeCategorie = new ArrayList<>();
		try {
			cnx = DBConnectPool.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);
			Categorie categorie;
			while (rs.next()) {
				categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.getLibelle();
			}
			
		
	} catch (SQLException) {
		
	} finally {
		
	}
	



}
