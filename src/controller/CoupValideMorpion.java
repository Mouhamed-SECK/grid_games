package controller;

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
    public boolean verifierCoupValide(Piece[][] grid, int col, int row) {
        // Vérifier si les coordonnées sont dans les limites de la grille
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        // Vérifier si la case est vide
        return grid[row][col] == Piece.EMPTY;
    }
}
