package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {

	private List<Element> elements;
	private Puits puits;

	public Tas(Puits puits) {
		// TODO Auto-generated constructor stub
		this.puits = puits;
		this.elements = new ArrayList<Element>();
		// construireTas(0, 1, new Random());
	}

	public Tas(Puits puits, int nbElements) {
		// TODO Auto-generated constructor stub
		this(puits, nbElements, (int) (nbElements / puits.getLargeur() + 1), new Random());
	}

	public Tas(Puits puits, int nbElements, int nbLignes) {
		// TODO Auto-generated constructor stub
		this(puits, nbElements, nbLignes, new Random());

	}

	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {

		// TODO Auto-generated constructor stub
		this.puits = puits;
		this.elements = new ArrayList<Element>();
		construireTas(nbElements, nbLignes, rand);

	}

	public Puits getPuits() {
		return puits;
	}

	public List<Element> getElements() {
		return this.elements;

	}

	public void ajouterElements(Piece piece) {

		for (int i = 0; i < piece.getElements().length; i++) {
			int abscisse = piece.getElements()[i].getCoordonnees().getAbscisse();
			int ordonnee = piece.getElements()[i].getCoordonnees().getOrdonnee();
			getElements().add(new Element(abscisse, ordonnee, piece.getElements()[0].getCouleur()));
		}

	}

	private void construireTas(int nbElements, int nbLignes, Random rand) {

		if (nbElements != 0 && nbElements >= getPuits().getLargeur() * nbLignes)
			throw new IllegalArgumentException("Non valide");

		int nbElementsPlace = 0;

		int ordon;
		int absci;
		int indiceCouleur;

		while (nbElementsPlace < nbElements) {
			ordon = getPuits().getProfondeur() - (rand.nextInt(nbLignes) + 1);
			absci = rand.nextInt(getPuits().getLargeur());

			if (!elementExists(absci, ordon)) {
				indiceCouleur = rand.nextInt(Couleur.values().length);

				getElements().add(new Element(absci, ordon, Couleur.values()[indiceCouleur]));
				nbElementsPlace++;
			}

		}

	}

	public boolean elementExists(int abscisse, int ordonnee) {

		int i = 0;
		boolean trouve = false;

		while (!trouve && i < getElements().size()) {

			Element element = getElements().get(i);

			if (element.getCoordonnees().getAbscisse() == abscisse
					&& element.getCoordonnees().getOrdonnee() == ordonnee) {
				trouve = true;
			}
			i++;

		}
		return trouve;
	}
	
	
	

}
