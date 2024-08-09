package fr.eseo.e3.poo.projet.blox.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CouleurTest {

	@Test
	void testcouleurPourAffichage() {
		Couleur c1 = Couleur.VERT ; 
		
		assertEquals(java.awt.Color.GREEN , c1.getCouleurPourAffichage() ,"couleur incorecte");
		
	}

}
