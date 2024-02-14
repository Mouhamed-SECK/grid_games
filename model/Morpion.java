package model;

/**
 * Extension of GameManagerModel for the game "Morpion".
 */
public class Morpion extends GameManagerModel {
    /**
     * Constructor for Morpion.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     * @param grid The initial grid configuration.
     */
    public Morpion(int row, int col, Piece[][] grid) {
        super(row, col, grid);
    }
}