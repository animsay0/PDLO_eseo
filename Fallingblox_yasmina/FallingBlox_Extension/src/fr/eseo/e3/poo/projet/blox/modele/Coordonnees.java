package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {

	private int abscisse;
	private int ordonnee;

	public Coordonnees(int abscisse, int ordonnee) {
		// TODO Auto-generated constructor stub
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	@Override
	public String toString() {
		return "(" + abscisse + ", " + ordonnee + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	public void deplacerDe(int deltaX, int deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Coordonnees)) {
			return false;
		}
		Coordonnees other = (Coordonnees) obj;
		return abscisse == other.abscisse && ordonnee == other.ordonnee;
	}

}
