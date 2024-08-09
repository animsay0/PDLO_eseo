package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class PuitsTest {

	@Test
	public void testConstructeurParDefaut() {
		Puits puits = new Puits();

		assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur(), "Largeur incorrecte");
		assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur(), "Profondeur incorrecte");
		assertNull(puits.getPieceActuelle(), "La piece n'est pas null");
		assertNull(puits.getPieceSuivante(), "La piece n'est pas null");

	}

	@Test
	public void testConstructeur() {
		Puits puits = new Puits(6, 17);

		assertEquals(6, puits.getLargeur(), "Largeur incorrecte");
		assertEquals(17, puits.getProfondeur(), "Profondeur incorrecte");
		assertNull(puits.getPieceActuelle(), "La piece n'est pas null");
		assertNull(puits.getPieceSuivante(), "La piece n'est pas null");

	}

	@Test
	public void testSetterExeption() {
		Puits puits = new Puits(8, 19);

		assertThrows(IllegalArgumentException.class, () -> {
			puits.setLargeur(4);
		}, "Message d'erreur");
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setLargeur(18);
		}, "Message d'erreur");
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setProfondeur(6);
		}, "Message d'erreur");
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setProfondeur(30);
		}, "Message d'erreur");
		
		try {
			puits.setLargeur(4);
		}catch (IllegalArgumentException e) {
			assertEquals("Out of bound", e.getMessage() , "L'exeption n'est pas lancer") ; 
		}

	}

	@Test
	public void testSetter() {
		Puits puits = new Puits(8, 19);
		puits.setLargeur(6);
		puits.setProfondeur(17);
		assertEquals(6, puits.getLargeur(), "Largeur incorrect");
		assertEquals(17, puits.getProfondeur(), "Profondeur incorrect");

	}

	@Test
	public void testSetPieceSuivante() {
		Puits puits = new Puits(8, 19);
		OTetromino o = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
		puits.setPieceSuivante(o);

		assertNull(puits.getPieceActuelle(), "La piece n'est pas null");
		assertNotNull(puits.getPieceSuivante(), "La piece est pas null");
		assertEquals(o, puits.getPieceSuivante(), "La piece ne correspond pas ");

	}

	@Test
	public void testSetPieceSuivante2() {
		Puits puits = new Puits(8, 19);
		OTetromino o = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);

		puits.setPieceSuivante(o);

		OTetromino o1 = new OTetromino(new Coordonnees(8, 17), Couleur.ROUGE);

		puits.setPieceSuivante(o1);
		assertNotNull(puits.getPieceActuelle(), "La piece est pas null");
		assertNotNull(puits.getPieceSuivante(), "La piece est pas null");
		assertEquals(o, puits.getPieceActuelle(), "La piece ne correspond pas ");
		assertEquals(new Coordonnees(4, -4), puits.getPieceActuelle().getElements()[0].getCoordonnees(), "Erreur ");
		assertEquals(o1, puits.getPieceSuivante(), "La piece ne correspond pas ");

	}

	@Test
	public void testToString() {
		Puits puits = new Puits(8, 19);

		String result = "Puits : Dimension 8 x 19\n" + "Piece Actuelle : <aucune>\n" + "Piece Suivante : <aucune>\n";

		assertEquals(result, puits.toString(), "Affichage Erronee");
	}

	@Test
	public void testToString2() {
		Puits puits = new Puits(8, 19);
		OTetromino o = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);

		puits.setPieceSuivante(o);

		String result = "Puits : Dimension 8 x 19\n" + "Piece Actuelle : <aucune>\n" + "Piece Suivante : " + o;

		assertEquals(result, puits.toString(), "Affichage Erronee");

		OTetromino o1 = new OTetromino(new Coordonnees(8, 17), Couleur.ROUGE);

		puits.setPieceSuivante(o1);

		String result2 = "Puits : Dimension 8 x 19\n" + "Piece Actuelle : " + o + "Piece Suivante : " + o1;

		assertEquals(result2, puits.toString(), "Affichage Erronee");
	}

}
