package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JFrame;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	public void testConstructeur() {
		
		Puits puits = new Puits();
		VuePuits vueP = new VuePuits(puits) ; 
		
		
		int largeurPreference = puits.getLargeur() * VuePuits.TAILLE_PAR_DEFAUT ; 
		int profondeurPreference = puits.getProfondeur() * 15 ; 
		
		
		
		JFrame f = new JFrame("frame")  ; 
		
		f.getContentPane().add(vueP);
		System.out.print(vueP.getPreferredSize().getWidth());
		assertEquals(puits, vueP.getPuits(),"There is a problem" );
		assertEquals(15 , vueP.getTaille(), "la taille par defaut ne correspond pas");
		assertEquals(largeurPreference , (int)vueP.getPreferredSize().getWidth() , "Le width ne correspond pas") ; 
		assertEquals(profondeurPreference ,(int) vueP.getPreferredSize().getHeight() , "Le height ne correspond pas") ; 
	}

}
