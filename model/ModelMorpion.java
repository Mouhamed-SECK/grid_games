package model;

/**
 * Extension of GameManagerModel for the game "Morpion".
 */
public class ModelMorpion extends ModelJeu {
    /**
     * Constructor for Morpion.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     * @param grid The initial grid configuration.
     */
    public ModelMorpion(int row, int col) {
        super(row, col);
    }
}