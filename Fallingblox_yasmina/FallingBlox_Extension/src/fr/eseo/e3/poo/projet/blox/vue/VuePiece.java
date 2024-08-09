package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {

	public static final double MULTIPLIER_TEINTE = 0.3;

	private final int taille;

	private final Piece piece;

	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;

	}

	public static Color teinte(Color couleur) {
		int red = couleur.getRed();
		int green = couleur.getGreen();
		int blue = couleur.getBlue();
		red = (int) (red + (255 - red) * MULTIPLIER_TEINTE);
		green = (int) (green + (255 - green) * MULTIPLIER_TEINTE);
		blue = (int) (blue + (255 - blue) * MULTIPLIER_TEINTE);
		return new Color(red,green,blue);
	}

	public void afficherPiece(java.awt.Graphics2D g2d) {

		Couleur couleurRef = piece.getElements()[0].getCouleur();

		int abcisseRef = piece.getElements()[0].getCoordonnees().getAbscisse() * taille;
		int ordonneRef = piece.getElements()[0].getCoordonnees().getOrdonnee() * taille;
		g2d.setColor(teinte(couleurRef.getCouleurPourAffichage()));
		g2d.fill3DRect(abcisseRef, ordonneRef, taille, taille, true);

		int abcisse, ordonne;

		for (int i = 1; i < piece.getElements().length; i++) {
			abcisse = piece.getElements()[i].getCoordonnees().getAbscisse() * taille;
			ordonne = piece.getElements()[i].getCoordonnees().getOrdonnee() * taille;
			g2d.setColor(couleurRef.getCouleurPourAffichage());
			g2d.fill3DRect(abcisse, ordonne, taille, taille, true);
		}

	}

}
