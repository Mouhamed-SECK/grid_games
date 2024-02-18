package controller;

import model.Coup;
import model.Piece;

/**
 * Cette classe implémente l'interface CoupValidStrategy pour la validation des coups
 * dans le jeu Tic-Tac-Toe (Morpion).
 */
public class CoupValideMorpion implements CoupValidStrategy {

    /**
     * Vérifie si un coup est valide dans la grille du jeu Tic-Tac-Toe.
     *
     * @param grid La grille de jeu représentée par un tableau de pièces.
     * @param col  La colonne où le coup est proposé.
     * @param row  La ligne où le coup est proposé.
     * @return true si le coup est valide, false sinon.
     */
    @Override
    public Coup verifierCoupValide(Piece[][] grid, int coup) throws Exception {
        // Vérifier si les coordonnées sont dans les limites de la grille

        // Convertir le coup en coordonnées (ligne, colonne) pour Morpion
        int totalrow = grid.length;
        int totalcol =  grid[0].length;

        int row = (coup - 1) / totalrow;
        int col = (coup - 1) % totalcol;
            
        if ( !(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && grid[row][col] == Piece.EMPTY) ){
                    throw new Exception("Coup non valide");

        };
        return new Coup(row, col);
    }
}
