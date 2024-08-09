package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {

    public static void main(String[] args) {
        new FallingBloxVersion1().testFallingBloxVersion1(args);
    }

    public void testFallingBloxVersion1(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Falling Blox");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            Puits puits = new Puits();
            VuePuits vuePuits = new VuePuits(puits);
            //Gravite gravite = new Gravite(vuePuits);
            PanneauInformation panneauInformation = new PanneauInformation(puits);

            
            puits.setPieceSuivante(UsineDePiece.genererTetromino());
            puits.setPieceSuivante(UsineDePiece.genererTetromino());
            puits.setPieceSuivante(UsineDePiece.genererTetromino());
            puits.getPieceActuelle().setPosition(2, 2);
            
            
            frame.add(vuePuits, BorderLayout.CENTER);
            frame.add(panneauInformation, BorderLayout.EAST);

            
            if (args.length == 1) {
                int nbElements = Integer.parseInt(args[0]);
                puits = new Puits(puits.getLargeur(), puits.getProfondeur(), nbElements, 3);
            } else if (args.length == 2) {
                int nbElements = Integer.parseInt(args[0]);
                int nbLignes = Integer.parseInt(args[1]);
                puits = new Puits(puits.getLargeur(), puits.getProfondeur(), nbElements, nbLignes);
            }

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    
        });
    }
}