package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class OTetrominoTest {

	@Test
	public void testConstructeur() {
		
		OTetromino piece = new OTetromino(new Coordonnees(4, 6), Couleur.JAUNE)  ; 
		
		Element[] tabtest = new Element[4] ;
		tabtest[0] = new Element (new Coordonnees(4, 6) ,Couleur.JAUNE );
		tabtest[1] = new Element (new Coordonnees(5, 5) ,Couleur.JAUNE );
		tabtest[2] = new Element (new Coordonnees(4, 5) ,Couleur.JAUNE );
		tabtest[3] = new Element (new Coordonnees(5, 6) ,Couleur.JAUNE );
		
		assertEquals(4, piece.getElements().length , "Le taille est incorrect");
		assertArrayEquals(tabtest, piece.getElements() , "Element non conforme");
		assertEquals(new Puits(), piece.getPuits() , "" );
		
		
	}

	
	@Test
	public void testToString() {

		OTetromino piece = new OTetromino(new Coordonnees(4, 6), Couleur.JAUNE)  ;
		
		String resultat = "OTetromino :\n"+ "\t(4, 6) - JAUNE\n"+"\t(5, 5) - JAUNE\n"
					+"\t(4, 5) - JAUNE\n"+"\t(5, 6) - JAUNE\n";
		
		assertEquals(resultat , piece.toString(), "La chaine ne correspond pas");	
		
	}
	
	
	@Test 
	public void testSetPosition() {
		OTetromino piece = new OTetromino(new Coordonnees(4, 6), Couleur.JAUNE)  ;
		
		piece.setPosition(8, 9);
		
		assertEquals(new Coordonnees(8, 9) , piece.getElements()[0].getCoordonnees() , "La piece n'a pas ete deplace" ) ; 
		assertEquals(new Coordonnees(9, 8) , piece.getElements()[1].getCoordonnees() , "La piece n'a pas ete deplace" ) ; 
		assertEquals(new Coordonnees(8, 8) , piece.getElements()[2].getCoordonnees() , "La piece n'a pas ete deplace" ) ; 
		assertEquals(new Coordonnees(9, 9) , piece.getElements()[3].getCoordonnees() , "La piece n'a pas ete deplace" ) ; 

		
	}
}
