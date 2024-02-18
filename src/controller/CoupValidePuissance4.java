package controller;

import model.Coup;
import model.Piece;

/**
 * Cette classe implémente l'interface CoupValidStrategy pour la validation des coups
 * dans le jeu Puissance 4.
 */
public class CoupValidePuissance4 implements CoupValidStrategy {

    /**
     * Vérifie si un coup est valide dans la grille du Puissance 4.
     *
     * @param grid La grille de jeu représentée par un tableau de pièces.
     * @param col  La colonne où le coup est proposé.
     * @param row  La ligne où le coup est proposé.
     * @return true si le coup est valide, false sinon.
     */
    @Override
    public Coup verifierCoupValide(Piece[][] grid,int coup) throws Exception {

        if (coup < 0 || coup >= grid[0].length  * grid.length)  {
            throw new Exception("Coup non valide : colonne hors limites");
        }

        int col = (coup - 1) % grid[0].length;
        int row = grid.length - 1;
    
        // Vérifier si la colonne est valide
       
    
        // Trouver la première case vide dans la colonne
        while (row >= 0 && grid[row][col] != Piece.EMPTY) {
            row--;
        }
    
        // Vérifier si la colonne contient une case vide
        if (row < 0) {
            throw new Exception("Coup non valide : colonne pleine");
        }
    
        return new Coup(row, col);



    }
}

