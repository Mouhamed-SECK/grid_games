package controller;

import model.IModelJeu;
import model.Observable;
import model.Piece;
import model.Player;

/**
 * Cette classe implémente l'interface CoupValidStrategy pour la validation des coups
 * dans le jeu Tic-Tac-Toe (Morpion).
 */
public class CoupValideMorpion implements CoupValidStrategy {
    
    private IModelJeu model;
    private Observable observable;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean verifierCoupValide(Piece[][] grid, int col, int row) {
        // Vérifier si les coordonnées sont dans les limites de la grille
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && grid[row][col] == Piece.EMPTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jouerCoup(int row, int col) {
        this.model.getGrid()[row][col] = this.model.getCurrentPlayer() == Player.CROSS ? Piece.CROSS : Piece.CIRCLE;
        this.observable.notifyObservers();
    }
}
