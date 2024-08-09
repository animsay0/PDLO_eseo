package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePieceTest {

	@Test
	void test() {
		UsineDePiece.setMode(2);

		Tetromino t = UsineDePiece.genererTetromino();

		OTetromino o = new OTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
		ITetromino i = new ITetromino(new Coordonnees(2, 3), Couleur.JAUNE);

		assertTrue(
				o.getElements()[0].getCoordonnees().equals(t.getElements()[0].getCoordonnees())
						|| i.getElements()[0].getCoordonnees().equals(t.getElements()[0].getCoordonnees()),
				"");
	}

	@Test
	public void testAleatoireComplet() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		Tetromino tetromino = UsineDePiece.genererTetromino();
		assertNotNull(tetromino);
		assertTrue(tetromino instanceof ITetromino || tetromino instanceof OTetromino);

	}

	@Test
	public void testCyclic() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		assertNotNull(piece1);
		assertTrue(piece1 instanceof OTetromino);
		Tetromino piece2 = UsineDePiece.genererTetromino();
		assertNotNull(piece2);
		assertFalse(piece2 instanceof OTetromino);
		assertFalse(piece1.equals(piece2));
	}

	
	

}
