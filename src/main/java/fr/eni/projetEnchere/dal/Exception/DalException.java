package fr.eni.projetEnchere.dal.Exception;

public class DalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DalException(String message, Throwable cause) {
		super(message,cause);
	}
	public DalException(String message) {
		super(message);
	}
	public DalException() {
		
	}
	@Override
	public String getMessage() {
		return "couche DAL " + super.getMessage() ;
	}

}
