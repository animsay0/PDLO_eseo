package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {

	private Element[] elements;
	private Puits puits;

	// private static int nbTetromino;

	public Tetromino(Coordonnees coordonne, Couleur couleur) {
		// TODO Auto-generated constructor stub
		this.elements = new Element[4];
		setElements(coordonne, couleur);
		this.puits = new Puits();
		// Tetromino.incrmentNbTetromino();
	}

	protected abstract void setElements(Coordonnees coordonne, Couleur couleur);

	public Element[] getElements() {
		return elements;
	}

	public void setPosition(int abscisse, int ordonnee) {
		setElements(new Coordonnees(abscisse, ordonnee), elements[0].getCouleur());
	}

	@Override
	public String toString() {
		String chaine = "";

		for (int i = 0; i < 4; i++) {
			chaine += "\t" + elements[i] + "\n";
		}

		return chaine;
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public void deplacerDe(int deltaX, int deltaY) throws BloxException {

		if (deltaX < -1 || deltaX > 1 || deltaY < 0 || deltaY > 1)
			throw new IllegalArgumentException("out of bound ");

		for (int i = 0; i < 4; i++) {
			Element elmts = new Element(getElements()[i].getCoordonnees().getAbscisse() + deltaX,
					getElements()[i].getCoordonnees().getOrdonnee() + deltaY);

			if (this.puits != null) {
				if (puits.getTas().elementExists(elmts.getCoordonnees().getAbscisse(),
						elmts.getCoordonnees().getOrdonnee()))
					throw new BloxException("Deplacement impossible : collision ", BloxException.BLOX_COLLISION);

				if (elmts.getCoordonnees().getAbscisse() < 0)
					throw new BloxException("Deplacemnt impossible : sortie du puit", BloxException.BLOX_SORTIE_PUITS);

				if (elmts.getCoordonnees().getAbscisse() >= this.puits.getLargeur())
					throw new BloxException("Deplacemnt impossible : sortie du puit", BloxException.BLOX_SORTIE_PUITS);

				if (elmts.getCoordonnees().getOrdonnee() >= getPuits().getProfondeur())
					throw new BloxException("Deplacement impossible : fond puit collision",
							BloxException.BLOX_COLLISION);
			}
		}

		for (int i = 0; i < 4; i++) {
			getElements()[i].deplacerDe(deltaX, deltaY);

		}

	}

	/*
	 * ANTI-PLAGIAT: La méthode tourner() est basé sur le travail de Augustin
	 * AGNALA.
	 */

	public void tourner(boolean sensHoraire) throws BloxException {

		if (this.puits != null) {
			for (int i = 0; i < this.elements.length; i++) {
				if (i != 0) {
					int absci = this.elements[i].getCoordonnees().getAbscisse()
							- this.elements[0].getCoordonnees().getAbscisse();
					int ordon = this.elements[i].getCoordonnees().getOrdonnee()
							- this.elements[0].getCoordonnees().getOrdonnee();
					int absciR, ordonR;
					if (!sensHoraire) {
						absciR = ordon;
						ordonR = -absci;
					} else {
						absciR = -ordon;
						ordonR = absci;
					}
					int newX = absciR + this.elements[0].getCoordonnees().getAbscisse();
					int newY = ordonR + this.elements[0].getCoordonnees().getOrdonnee();
					if (newX < 0 || newX >= puits.getLargeur()) {
						throw new BloxException("Sortie du puits impossible", BloxException.BLOX_SORTIE_PUITS);
					} else if (puits.getTas().elementExists(newX, newY) || newY >= puits.getProfondeur()) {
						throw new BloxException("Collision impossible", BloxException.BLOX_COLLISION);
					}
				}
			}
		}

		for (int i = 0; i < this.elements.length; i++) {
			if (i != 0) {
				int absci = this.elements[i].getCoordonnees().getAbscisse()
						- this.elements[0].getCoordonnees().getAbscisse();
				int ordon = this.elements[i].getCoordonnees().getOrdonnee()
						- this.elements[0].getCoordonnees().getOrdonnee();
				int absciR, ordonR;
				if (!sensHoraire) {
					absciR = ordon;
					ordonR = -absci;
				} else {
					absciR = -ordon;
					ordonR = absci;
				}
				int newX = absciR + this.elements[0].getCoordonnees().getAbscisse();
				int newY = ordonR + this.elements[0].getCoordonnees().getOrdonnee();
				this.elements[i].setCoordonnees(new Coordonnees(newX, newY));
			}

		}
	}

}
