package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 323361076995931312L;
	public static final  int BLOX_COLLISION = 0  ;
	public static final  int BLOX_SORTIE_PUITS = 1;
	
	private int type ;  
	
	public BloxException(String message , int type) {
		// TODO Auto-generated constructor stub
		super(message);
		this.type = type ; 
	}

	public int getType() {
		return this.type ; 
	}
	
}
