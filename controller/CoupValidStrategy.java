package controller;

import model.Piece;

public interface CoupValidStrategy {

    public boolean verifierCoupValide(Piece[][] grid, int col, int row);

    
} 