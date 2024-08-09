package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter {

	private Puits puits;
	private VuePuits vuePuits;
	private int ancColonne = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		// TODO Auto-generated constructor stub
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public VuePuits getVuePuits() {
		return vuePuits;
	}

	public void setVuePuits(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
	}

	public void mouseMoved(MouseEvent event) {
		if (this.puits.getPieceActuelle() != null) {
			// System.out.println("ok");
			int colonneActu = (int) (event.getX() / getVuePuits().getTaille());
			if (ancColonne == -1) {
				ancColonne = colonneActu;
			} else if (ancColonne != -1 && colonneActu != ancColonne) {
				if (colonneActu - ancColonne < 0) {
					try {
						this.puits.getPieceActuelle().deplacerDe(-1, 0);
					} catch (BloxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (colonneActu - ancColonne > 0) {
					try {
						this.puits.getPieceActuelle().deplacerDe(1, 0);
					} catch (BloxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ancColonne = colonneActu;
			}
			this.vuePuits.repaint();
		}

	}

	public int getAncColonne() {
		return ancColonne;
	}

	public void setAncColonne(int ancColonne) {
		this.ancColonne = ancColonne;
	}

	public void mouseEntered(MouseEvent event) {
		setAncColonne(-1);
	}

	public void mouseWheelMoved(MouseWheelEvent event) {
		if (this.puits.getPieceActuelle() != null) {
			if (event.getWheelRotation() > 0) {
				try {
					getPuits().getPieceActuelle().deplacerDe(0, 1);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.vuePuits.repaint();
		}
	}

}
