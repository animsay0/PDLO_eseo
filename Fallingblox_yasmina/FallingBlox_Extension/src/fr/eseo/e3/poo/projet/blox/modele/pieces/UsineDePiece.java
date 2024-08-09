package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;

import java.util.Random;

public class UsineDePiece {

	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 3;

	private static int modeChoisi = ALEATOIRE_PIECE;
	// private static int random = ;
	private static int memory = 0;

	private UsineDePiece() {
		// TODO Auto-generated constructor stub
	}

	public static void setMode(int mode) {
		// I don't know what I am supposed to do here ;
		if (mode == ALEATOIRE_PIECE || mode == ALEATOIRE_COMPLET || mode == CYCLIC)
			modeChoisi = mode;

	}

	public static Tetromino genererTetromino() {
		Random random = new Random();
		Tetromino t = null;
		Couleur couleurAl = Couleur.values()[random.nextInt(Couleur.values().length)];

		if (modeChoisi == ALEATOIRE_COMPLET) {
			t = tetrominoAlComplet(random.nextInt(7), couleurAl);

		} else if (modeChoisi == ALEATOIRE_PIECE) {
			t = tetrominoAlPiece(random.nextInt(7));

		} else if (modeChoisi == CYCLIC) {
			t = tetrominoAlPiece(memory % 7);
			memory++;
		}
		return t;
	}

	private static Tetromino tetrominoAlComplet(int indice, Couleur couleur) {

		Tetromino[] t = new Tetromino[7];

		t[0] = new OTetromino(new Coordonnees(2, 3), couleur);
		t[1] = new ITetromino(new Coordonnees(2, 3), couleur);
		t[2] = new TTetromino(new Coordonnees(2, 3), couleur);
		t[3] = new LTetromino(new Coordonnees(2, 3), couleur);
		t[4] = new JTetromino(new Coordonnees(2, 3), couleur);
		t[5] = new ZTetromino(new Coordonnees(2, 3), couleur);
		t[6] = new STetromino(new Coordonnees(2, 3), couleur);

		return t[indice];

	}

	private static Tetromino tetrominoAlPiece(int indice) {

		Tetromino[] t = new Tetromino[7];

		t[0] = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
		t[1] = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
		t[2] = new TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
		t[3] = new LTetromino(new Coordonnees(2, 3), Couleur.VERT);
		t[4] = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
		t[5] = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
		t[6] = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);

		return t[indice];

	}

}
