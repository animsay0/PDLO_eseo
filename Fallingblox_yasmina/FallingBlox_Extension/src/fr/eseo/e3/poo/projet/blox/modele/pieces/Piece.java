package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public interface Piece {

	public void setPosition(int abscisse, int ordonnee);

	public Element[] getElements();

	public Puits getPuits();

	public void setPuits(Puits puits);

	public void deplacerDe(int deltaX, int deltaY) throws BloxException ;
	
	public void tourner(boolean sensHoraire) throws BloxException ;
}
