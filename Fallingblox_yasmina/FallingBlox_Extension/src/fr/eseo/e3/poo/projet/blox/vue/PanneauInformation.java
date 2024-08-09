package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Puits puits;
	private VuePiece vuePiece;

	public PanneauInformation(Puits puits) {
		// TODO Auto-generated constructor stub
		setPuits(puits);
		this.vuePiece = null;
		this.setPreferredSize(new Dimension(70, 70));
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g.create();

		if (vuePiece != null)
			vuePiece.afficherPiece(g2D);

		g2D.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
			Piece pieceSuivante = (Piece) evt.getNewValue();
			if (pieceSuivante != null)
				setVuePiece(new VuePiece(pieceSuivante, 10));
		}
		this.repaint();
	}

	private void setVuePiece(VuePiece vuePiece) {
		// TODO Auto-generated method stub
		this.vuePiece = vuePiece;

	}

}
