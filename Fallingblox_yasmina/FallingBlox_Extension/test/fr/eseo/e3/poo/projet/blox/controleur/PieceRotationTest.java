package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {

	public PieceRotationTest() {
		testRotation();
	}

	private void testRotation() {
		Puits puits = new Puits(10,20);
		VuePuits vuePuits = new VuePuits(puits);
		JFrame myFrame = new JFrame("Puits");
		PieceDeplacement pieceDeplacement = new PieceDeplacement(vuePuits) ; 
		vuePuits.getPuits().addPropertyChangeListener(vuePuits);
		pieceDeplacement.setPuits(puits);
		
		UsineDePiece.setMode(3);
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
        puits.getPieceActuelle().setPosition(2, 4);

		myFrame.add(vuePuits);
		myFrame.pack();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PieceRotationTest();
			}
		});
	}

}
