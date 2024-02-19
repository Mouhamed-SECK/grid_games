package controller;

import model.Coup;
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
     * @param coup le coup à jouer
     * @return true si le coup est valide, false sinon.
     */
    Coup verifierCoupValide(Piece[][] grid, int coup) throws Exception;
}
