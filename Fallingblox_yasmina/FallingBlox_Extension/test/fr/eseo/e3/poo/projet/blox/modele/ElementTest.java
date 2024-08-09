package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	public void testConstructeurCoordonne() {
		Coordonnees c = new Coordonnees(10, 50);
		Element e = new Element(c);

		assertEquals(c, e.getCoordonnees(), "Les coordonnees ne corespondent pas");
	}

	@Test
	public void testConstructeurAbscisseOrdonnee() {
		Element e = new Element(10, 89);

		assertEquals(new Coordonnees(10, 89), e.getCoordonnees(), "Les coordonnees ne corespondent pas");
	}

	@Test
	public void testConstructeurCoordonneCouleur() {
		Coordonnees c = new Coordonnees(10, 50 );
		Couleur color = Couleur.BLEU;
		Element e = new Element(c , color);

		assertEquals(c, e.getCoordonnees(), "Les coordonnees ne correspondent pas");
		assertEquals(color, e.getCouleur(), "La couleur ne correspond pas");

	}

	@Test
	public void testConstructeurAbbscisseOrdonneeCouleur() {
		// Coordonnees c = new Coordonnees(10, 50);
		Couleur color = Couleur.BLEU;
		Element e = new Element(26, 77, color);

		assertEquals(new Coordonnees(26, 77), e.getCoordonnees(), "Les coordonnees ne correspondent pas");
		assertEquals(color, e.getCouleur(), "La couleur ne correspond pas");

	}
	
	@Test 
	public void testSetters() {
		Coordonnees c = new Coordonnees(10, 50 );
		Couleur color = Couleur.BLEU;
		Element e = new Element(c , color);
		
		e.setCoordonnees(new Coordonnees(0, 0));
		e.setCouleur(Couleur.JAUNE);

		assertEquals(new Coordonnees(0, 0), e.getCoordonnees(), "Les coordonnees ne corespondent pas");
		assertEquals(Couleur.JAUNE, e.getCouleur(), "La couleur ne correspond pas");
	}
	
	@Test
	public void testToString() {
		Coordonnees c = new Coordonnees(10, 50);
		Couleur color = Couleur.BLEU;
		Element e = new Element(c, color);

		assertEquals("(10, 50) - BLEU", e.toString(), "L'affichage est mauvais");
		// assertEquals(color, e.getCouleur(), "Les coordonnees ne corespondent pas");

	}
	
	@Test 
	public void testHashCodeandEquals() {
		Coordonnees c1 = new Coordonnees(10, 50 );
		Coordonnees c2 = new Coordonnees(10, 50 );
		//Couleur color = Couleur.BLEU;

		Element e1 = new Element(c1 ,  Couleur.BLEU);
		Element e2 = new Element(c2 ,  Couleur.BLEU);

		assertTrue(e1.equals(e2), "Les elements sont differents");
		assertTrue(e2.equals(e1), "Les elements sont differents");
		assertTrue(e1.hashCode() == e2.hashCode(), "Les hashcode sont differents");
		
		Element e3 = new Element(c1 , Couleur.JAUNE);
		
		assertFalse(e3.equals(e1), "Les elements sont pareils");
		assertFalse(e1.hashCode() == e3.hashCode(), "Les hashcode sont pareil");
		
	}
	
	
	@Test 
	public void testDeplacerDe() {
		Coordonnees c = new Coordonnees(0, 0);
		Couleur color = Couleur.BLEU;
		Element e = new Element(c , color);
		e.deplacerDe(4,6);
		
		assertEquals(new Coordonnees(4,6), e.getCoordonnees(), "Les coordonnees ne corespondent pas");
		
		
		
	}
	
	
}