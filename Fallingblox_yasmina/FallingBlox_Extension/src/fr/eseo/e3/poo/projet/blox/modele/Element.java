package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

	private Coordonnees coordonnees;
	private Couleur couleur;

	public Element(Coordonnees coordonnees, Couleur couleur) {
		// TODO Auto-generated constructor stub
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}

	public Element(int abscisse, int ordonnee) {
		// TODO Auto-generated constructor stub
		this(new Coordonnees(abscisse, ordonnee));
	}

	public Element(Coordonnees coordonnees) {
		// TODO Auto-generated constructor stub
		this(coordonnees, Couleur.values()[0]);

	}

	public Element(int abscisse, int ordonnee, Couleur couleur) {
		// TODO Auto-generated constructor stub
		this(new Coordonnees(abscisse, ordonnee), couleur);

	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void deplacerDe(int deltaX, int deltaY) {
		getCoordonnees().deplacerDe(deltaX, deltaY);
	}

	@Override
	public String toString() {
		return coordonnees + " - " + couleur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Element)) {
			return false;
		}
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
}
