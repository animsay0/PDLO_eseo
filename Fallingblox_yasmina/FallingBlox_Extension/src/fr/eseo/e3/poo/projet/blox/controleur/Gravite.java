package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener{

	private Timer timer;
	private final Puits puits;
	private final VuePuits vuePuits; 
	public static final int PERIODICITE = 1000; 
	
	public Gravite(VuePuits vuePuits) {
		// TODO Auto-generated constructor stub
		this.vuePuits = vuePuits ; 
		this.puits = vuePuits.getPuits() ;
		//this.periodicite = 500 ; 
		this.timer = new Timer(PERIODICITE, this) ;
		
		timer.start();
	
	}

	public int getPeriodicite() {
		return this.timer.getDelay(); 
	}
	
	public void  setPeriodicite(int periodicite) {
		//this.periodicite = periodicite ;
		this.timer.setDelay(periodicite);
	}
	
	public void actionPerformed (ActionEvent evt ) {
		puits.gravite();  
		this.vuePuits.repaint();
	}

	public Timer getTimer() {
		// TODO Auto-generated method stub
		return this.timer;
	}
	
	
}
