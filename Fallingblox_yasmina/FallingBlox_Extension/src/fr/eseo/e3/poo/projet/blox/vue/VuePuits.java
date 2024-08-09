package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int TAILLE_PAR_DEFAUT = 15;

	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement ;
	private PieceRotation pieceRotation ;
	private final VueTas vueTas ; 

	public VuePuits(Puits puits) {
		// TODO Auto-generated constructor stub
		this(puits, TAILLE_PAR_DEFAUT);
	}

	public VuePuits(Puits puits, int taille) {
		// TODO Auto-generated constructor stub
		this.pieceDeplacement = new PieceDeplacement(this) ; 
		this.pieceRotation = new PieceRotation(this) ; 
		setPuits(puits);
		setTaille(taille);
		this.vuePiece = null;
		this.vueTas = new VueTas(this, taille) ; 
		this.setBackground(Color.WHITE);
		
		
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		if (getPuits() != null)
			this.puits.removePropertyChangeListener(this);
		this.puits = puits;
		this.setPreferredSize(
				new Dimension(getPuits().getLargeur() * getTaille(), getPuits().getProfondeur() * getTaille()));
		this.puits.addPropertyChangeListener(this);
		this.pieceDeplacement.setPuits(puits);
		this.pieceRotation.setPuits(puits);
		
		this.removeMouseListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		
		this.removeMouseListener(pieceRotation);
		this.addMouseListener(pieceRotation);

		this.removeMouseMotionListener(pieceDeplacement);
		this.addMouseMotionListener(pieceDeplacement);
		
		this.removeMouseWheelListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
				
		//repaint() ;
	}

	public int getTaille() {
		return taille;

	}

	public void setTaille(int taille) {
		this.taille = taille;
		this.setPreferredSize(
				new Dimension(getPuits().getLargeur() * getTaille(), getPuits().getProfondeur() * getTaille()));
		repaint() ;
	
				
	}

	protected void paintComponent(Graphics g) {
		/* appel vers super pour remplir le fond du JPanel */
		/*
		 * Le paramètre g est copie en utilisant la méthode copie() puis converti en
		 * instance de Graphics2D grâce à un transtypage (cast) explicite.
		 */
		super.paintComponent(g);

		this.setBackground(Color.WHITE);
		
		Graphics2D g2D = (Graphics2D) g.create();
		/* Nous utiliserons l'instance de Graphics2D */
		/* Puis nous liberons la memoire */
		g2D.setColor(Color.LIGHT_GRAY);
		
		for (int i = 0; i <= getPuits().getLargeur(); i++) {
			g2D.drawLine(i * getTaille(), 0, i * getTaille(), getPuits().getProfondeur() * getTaille());
		}

		for (int j = 0; j <= getPuits().getProfondeur(); j++) {
			g2D.drawLine(0, j * getTaille(), getPuits().getLargeur() * getTaille(), j * getTaille());
		}
		
		if (vueTas != null)
			vueTas.afficher(g2D);
		
		if (vuePiece != null)
			vuePiece.afficherPiece(g2D);

		g2D.dispose();
	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		 //this.puits.setPieceSuivante(UsineDePiece.genererTetromino());

		if (evt.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			Piece pieceActuelle = (Piece) evt.getNewValue();
			if (pieceActuelle != null)
				setVuePiece(new VuePiece(pieceActuelle, getTaille()));
		}
	}
}
