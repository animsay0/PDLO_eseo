package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class Puits {

	public static final int LARGEUR_PAR_DEFAUT = 15;
	public static final int PROFONDEUR_PAR_DEFAUT = 25;

	public static final String MODIFICATION_PIECE_ACTUELLE = "actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "suivante";

	private int largeur;
	private int profondeur;

	private Piece pieceActuelle;
	private Piece pieceSuivante;

	private PropertyChangeSupport pcs;
	private Tas tas;

	public Puits() {
		// TODO Auto-generated constructor stub
		this(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT);
	}

	public Puits(int largeur, int profondeur) {

		setLargeur(largeur);
		setProfondeur(profondeur);
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}

	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {

		setLargeur(largeur);
		setProfondeur(profondeur);
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this, nbElements, nbLignes);

	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		if (largeur < 5 || largeur > 15)
			throw new IllegalArgumentException("Out of bound");

		this.largeur = largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25)
			throw new IllegalArgumentException("Out of bound");

		this.profondeur = profondeur;
	}

	public Tas getTas() {
		return tas;
	}

	public void setTas(Tas tas) {
		this.tas = tas;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		if (getPieceSuivante() != null) {
			this.pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, getPieceActuelle(), getPieceSuivante());
			this.pieceActuelle = this.getPieceSuivante();
			this.pieceActuelle.setPuits(this);
			this.getPieceActuelle().setPosition(getLargeur() / 2, -4);

		}

		this.pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, getPieceSuivante(), pieceSuivante);
		this.pieceSuivante = pieceSuivante;
		this.pieceSuivante.setPuits(this);

	}

	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	@Override
	public String toString() {
		String a = "Puits : Dimension " + this.getLargeur() + " x " + this.getProfondeur() + "\n";
		String b = "Piece Actuelle : ";

		if (pieceActuelle == null)
			b += "<aucune>\n";
		else
			b += pieceActuelle;

		String c = "Piece Suivante : ";
		if (pieceSuivante == null)
			c += "<aucune>\n";
		else
			c += pieceSuivante;
		return a + b + c;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	private void gererCollision() {
		if (getPieceActuelle() != null) {
			getTas().ajouterElements(getPieceActuelle());
			setPieceSuivante(UsineDePiece.genererTetromino());
		}
	}

	public void gravite() {
		if (getPieceActuelle() != null) {
			try {
				getPieceActuelle().deplacerDe(0, 1);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				if (e.getType() == BloxException.BLOX_COLLISION) {
					// getTas().ajouterElements(getPieceActuelle());
					gererCollision();
					// this.tas.ajouterElements(getPieceActuelle());
					// setPieceSuivante(UsineDePiece.genererTetromino());
				}
			}
		}
	}
}
