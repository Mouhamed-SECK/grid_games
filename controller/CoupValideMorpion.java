package controller;

import model.Piece;

public class CoupValideMorpion implements CoupValidStrategy {

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