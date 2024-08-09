package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class STetromino extends Tetromino {

	public STetromino(Coordonnees coordonne, Couleur couleur) {
		// TODO Auto-generated constructor stub
		super(coordonne , couleur);
	}

	@Override
	protected void setElements(Coordonnees coordonne, Couleur couleur) {
		// TODO Auto-generated method stub
		super.getElements()[0] = new Element(coordonne, couleur);
		super.getElements()[1] = new Element(coordonne.getAbscisse(), coordonne.getOrdonnee() -1, couleur);
		super.getElements()[2] = new Element(coordonne.getAbscisse() + 1 , coordonne.getOrdonnee() -1, couleur);
		super.getElements()[3] = new Element(coordonne.getAbscisse()-1, coordonne.getOrdonnee(), couleur);
	}
	
	@Override
	public String toString() {

		return "ZTetromino :\n" + super.toString();
	}

}
