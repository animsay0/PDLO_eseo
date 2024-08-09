package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class VuePuitsAffichageTest {

	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
		// testAffichagePiece();
		// testAffichageTas();
	}

	private void testConstructeurPuits() {
		Puits puits = new Puits();
		VuePuits p = new VuePuits(puits);
		JFrame myFrame = new JFrame("Puits");

		myFrame.add(p);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

	private void testConstructeurPuitsTaille() {
		Puits puits = new Puits();
		VuePuits p = new VuePuits(puits, 9);
		JFrame myFrame = new JFrame("Puits et taille");

		myFrame.add(p);
		myFrame.pack();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		p.repaint();
	}

	private void testAffichagePiece() {
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		JFrame myFrame = new JFrame("Puits");

		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.getPieceActuelle().setPosition(2, 4);

		myFrame.add(vuePuits);
		myFrame.pack();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);

	}

	private void testAffichageTas() {
		Puits puits = new Puits(10, 20);
		Tas tas = new Tas(puits, 17, 4);
		puits.setTas(tas);

		VuePuits vuePuits = new VuePuits(puits);
		JFrame myFrame = new JFrame("Puits");

		// puits.setPieceSuivante(UsineDePiece.genererTetromino());
		// puits.setPieceSuivante(UsineDePiece.genererTetromino());
		// puits.getPieceActuelle().setPosition(2, 4);

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
				new VuePuitsAffichageTest();
			}
		});
	}
}
