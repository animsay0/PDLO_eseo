package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {

	private Puits puits;
	private VuePuits vuePuits;

	public PieceRotation(VuePuits vuePuits) {
		// TODO Auto-generated constructor stub'
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

	@Override
	public void mouseClicked(MouseEvent event) {

		if (getPuits().getPieceActuelle() != null) {
			if (SwingUtilities.isRightMouseButton(event))
				try {
					getPuits().getPieceActuelle().tourner(true);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else if (SwingUtilities.isLeftMouseButton(event))
				try {
					getPuits().getPieceActuelle().tourner(false);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			vuePuits.repaint(); 

		}
	}
}
