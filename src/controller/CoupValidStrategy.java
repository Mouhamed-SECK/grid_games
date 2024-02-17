package controller;

import model.Piece;

/**
 * L'interface CoupValidStrategy définit une stratégie pour la validation des coups
 * dans un jeu de plateau.
 */
public interface CoupValidStrategy {

    /**
     * Vérifie si un coup est valide dans la grille du jeu.
     *
     * @param grid La grille de jeu représentée par un tableau de pièces.
     * @param col  La colonne où le coup est proposé.
     * @param row  La ligne où le coup est proposé.
     * @return true si le coup est valide, false sinon.
     */
    boolean verifierCoupValide(Piece[][] grid, int col, int row);
}
