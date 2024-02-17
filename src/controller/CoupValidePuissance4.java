package controller;

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
    public boolean verifierCoupValide(Piece[][] grid, int col, int row) {
        // Vérifier si les coordonnées sont dans les limites de la grille
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        // Vérifier si la colonne n'est pas pleine
        if (grid[0][col] != Piece.EMPTY) {
            return false;
        }

        // Trouver la première case vide dans la colonne
        int emptyRow = grid.length - 1;
        while (emptyRow >= 0 && grid[emptyRow][col] != Piece.EMPTY) {
            emptyRow--;
        }

        // Vérifier si la colonne contient une case vide
        return emptyRow >= 0;
    }
}

