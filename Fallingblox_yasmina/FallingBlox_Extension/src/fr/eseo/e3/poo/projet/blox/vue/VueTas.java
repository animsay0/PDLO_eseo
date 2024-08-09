package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

	public static final double  MULTIPLIER_NUANCE = 0.4 ;
	private final VuePuits vuePuits ;  
	private final Tas tas; 
	private int taille; 
	
	public void setTaille(int taille) {
		this.taille = taille;
	}

	public VueTas(VuePuits vuePuits , int taille) {
		// TODO Auto-generated constructor stub
		this.taille = taille; 
		this.tas = vuePuits.getPuits().getTas();
		this.vuePuits = vuePuits ;
	}
	
	public VueTas(VuePuits vuePuits) {
		this(vuePuits, VuePuits.TAILLE_PAR_DEFAUT) ;
	}
	
	
	public static Color nuance(Color couleur) {
		int red = couleur.getRed();
		int green = couleur.getGreen();
		int blue = couleur.getBlue();
		red = (int)(red*(1 - MULTIPLIER_NUANCE) ); 
		green = (int)(green*(1 - MULTIPLIER_NUANCE) ); 
		blue = (int)(blue*(1- MULTIPLIER_NUANCE)) ; 
		
		return new Color(red , green , blue ) ; 
	}
	
	public void afficher(Graphics2D g2D) {

		// if (!tas.getElements().isEmpty()) {
		for (Element e : tas.getElements()) {
			g2D.setColor(nuance(e.getCouleur().getCouleurPourAffichage()));
			// System.out.println(e.getCoordonnees().toString());

			g2D.fill3DRect(e.getCoordonnees().getAbscisse() * taille, e.getCoordonnees().getOrdonnee() * taille, taille,
					taille, false);
		}
		vuePuits.setBackground(Color.WHITE);
		// vuePuits.repaint();
	}
	

	public VuePuits getVuePuits() {
		return vuePuits;
	}

	public int getTaille() {
		return taille;
	}

}
