package model;

/**
 * Extension of GameManagerModel for the game "Puissance4".
 */
public class Puissance4 extends GameManagerModel {
    /**
     * Constructor for Puissance4.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     * @param grid The initial grid configuration.
     */
    public Puissance4(int row, int col, Piece[][] grid) {
        super(row, col, grid);
    }
}
