package controller;

import model.IModelJeu;
import model.Observable;
import model.Piece;
import model.Player;

/**
 * Cette classe implémente l'interface CoupValidStrategy pour la validation des coups
 * dans le jeu Puissance 4.
 */
public class CoupValidePuissance4 implements CoupValidStrategy {
    
    private IModelJeu model;
    private Observable observable;
    
    /**
    * {@inheritDoc}
    */
    @Override
    public boolean verifierCoupValide(Piece[][] grid, int col, int row) {
        // Vérifier si la colonne est valide
        if (col < 0 || col >= grid[0].length) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void jouerCoup(int row, int col) {
        // Trouver la première case vide dans la colonne
        int emptyRow = this.model.getGrid().length - 1;
        while (emptyRow >= 0 && this.model.getGrid()[emptyRow][col] != Piece.EMPTY) {
            emptyRow--;
        }

        // Jouer le coup dans la première case vide de la colonne
        if (emptyRow >= 0) {
            this.model.getGrid()[emptyRow][col] = this.model.getCurrentPlayer() == Player.CROSS ? Piece.CROSS : Piece.CIRCLE;
            this.observable.notifyObservers();
        }
    }

}

