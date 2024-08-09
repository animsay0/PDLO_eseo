package fr.eseo.e3.poo.projet.blox.modele;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	void testGetters() {
		Coordonnees c = new Coordonnees(10, 30);

		assertEquals(10, c.getAbscisse(), "L'abscisse ne corespond pas");
		assertEquals(30, c.getOrdonnee(), "L'ordonnee ne corespond pas");
		assertEquals("(10, 30)", c.toString(), "L'affichage n'est pas bon");

	}
	
	@Test
	void testSetters() {
		Coordonnees c = new Coordonnees(10, 30);
		c.setAbscisse(49);
		c.setOrdonnee(66);

		assertEquals(49, c.getAbscisse(), "L'abscisse ne corespond pas");
		assertEquals(66, c.getOrdonnee(), "L'ordonnee ne corespond pas");

	}

}
