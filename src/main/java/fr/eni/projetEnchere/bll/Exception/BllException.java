package fr.eni.projetEnchere.bll.Exception;

public class BllException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BllException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		return  super.getMessage() ;
	}
}
