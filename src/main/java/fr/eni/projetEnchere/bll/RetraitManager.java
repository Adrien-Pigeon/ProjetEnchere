package fr.eni.projetEnchere.bll;

import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.RetraitDAO;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class RetraitManager {

	private static RetraitManager instance = null;

	private RetraitManager() {
	}

	public static RetraitManager getInstanceRetrait() {

		if (instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}

	public void ajouterRetrait(Retrait retrait) throws BllException {
		// instancier un objet retraitDao
		RetraitDAO retraitDao = DAOFactory.getRetraitDAO();


		try {
			// valider l'objet retrait
			//validerRetrait(retrait);
			// inserer le retrait dans ma base de donn�e
			retraitDao.insertRetrait(retrait);
		} catch (DalException e) {
			
			throw new BllException("Echec ajouterRetrait");
		}
	}
	
	public Retrait choixRetrait(int noArticle) throws BllException{
		RetraitDAO retraitDao = DAOFactory.getRetraitDAO();
		Retrait  retrait = null;
			//selectionner un retraitvdans la base de donn�e
			try {
				retrait = retraitDao.SelectByNoArticle(noArticle);
			} catch (DalException e) {
				throw new BllException("Echec choixRetrait");
			}
			return retrait;
		
	}

	public static void validerRetrait(Retrait r) throws BllException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		if (r == null) {
			throw new BllException("Retrait null");
		}
		// Les attributs des articles sont obligatoires
		if (r.getVille() == null || r.getVille().trim().length() == 0) {
			sb.append("La ville de retrait est obligatoire.\n");
			valide = false;
		}
		if (r.getRue() == null || r.getRue().trim().length() == 0) {
			sb.append("La rue du retrait est obligatoire.\n");
			valide = false;
		}
		if (r.getCodePostal() == null || r.getCodePostal().trim().length() == 0) {
			sb.append("Le code postal est obligatoire.\n");
			valide = false;
		}
		try {
            Float f = Float.parseFloat(r.getCodePostal());
        } catch (NumberFormatException e) {
        	sb.append("Le code Postal ne doit comporter que des chiffres");
        	valide  = false;
            
        }


		if (!valide) {
			throw new BllException(sb.toString());
		}
	}
}
