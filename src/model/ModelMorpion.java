package model;

/**
 * Extension of GameManagerModel for the game "Morpion".
 */
public  class ModelMorpion extends ModelJeu {
    /**
     * Constructor for Morpion.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     */
    public ModelMorpion(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean isGameOver() {
        // Check for a winning line or a full board
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true; // A player has won
            }
        }
        if (checkDiagonals()) {
            return true; // A player has won
        }
        return isGridFull(); // The game is a draw if the grid is full
    }
    
    private boolean checkRow(int rowIndex) {
        Piece first = grid[rowIndex][0];
        if (first == Piece.EMPTY) return false;
        for (int colIndex = 1; colIndex < 3; colIndex++) {
            if (grid[rowIndex][colIndex] != first) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkColumn(int colIndex) {
        Piece first = grid[0][colIndex];
        if (first == Piece.EMPTY) return false;
        for (int rowIndex = 1; rowIndex < 3; rowIndex++) {
            if (grid[rowIndex][colIndex] != first) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkDiagonals() {
        Piece topLeft = grid[0][0];
        Piece topRight = grid[0][2];
        boolean diagonal1 = topLeft != Piece.EMPTY;
        boolean diagonal2 = topRight != Piece.EMPTY;
        
        for (int i = 1; i < 3; i++) {
            if (grid[i][i] != topLeft) diagonal1 = false;
            if (grid[i][2 - i] != topRight) diagonal2 = false;
        }
        
        return diagonal1 || diagonal2;
    }
    
    private boolean isGridFull() {
        for (Piece[] row : grid) {
            for (Piece piece : row) {
                if (piece == Piece.EMPTY) {
                    return false; // There are still moves to make
                }
            }
        }
        return true; // No moves left
    }
    
}

