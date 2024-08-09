package fr.eseo.e3.poo.projet.blox.modele;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TasTest {

	@Test
	void test() {
		Tas tas = new Tas(new Puits()) ; 
		
		tas.getElements().add(new Element(2,8)) ; 
		
		assertTrue(tas.elementExists(2, 8), "l'element n,es pas present ");
	}
	
	@Test
	void test1() {
		Tas tas = new Tas(new Puits(),10,2) ; 
		
		
		for(Element e : tas.getElements()) {
			System.out.print(e.getCoordonnees().toString());
		}
		
		
	}
	
	
	
	



}
