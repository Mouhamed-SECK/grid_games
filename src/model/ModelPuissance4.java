package model;
import controller.GameStatus;

/**
 * Extension of GameManagerModel for the game "Puissance4".
 */
public class ModelPuissance4 extends ModelJeu {
    /**
     * Constructor for Puissance4.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     * @param grid The initial grid configuration.
     */
    public ModelPuissance4(int row, int col) {
        super(row, col);
    }

    @Override
    public GameStatus isGameOver() {
        // Check all possible directions for a winning line
        for (int rowIndex = 0; rowIndex < getRow(); rowIndex++) {
            for (int colIndex = 0; colIndex < getCol(); colIndex++) {
                if (grid[rowIndex][colIndex] != Piece.EMPTY) {
                    if (checkVertical(rowIndex, colIndex) || 
                        checkHorizontal(rowIndex, colIndex) || 
                        checkDiagonalRight(rowIndex, colIndex) || 
                        checkDiagonalLeft(rowIndex, colIndex)) {
                        return currentPlayer == Player.CROSS ? GameStatus.PLAYER_1_WIN : GameStatus.PLAYER_2_WIN;
                    }
                }
            }
        }
        if (isGridFull()) {
            return GameStatus.DRAW;
        }
        return GameStatus.IN_PROGRESS;
    }
    
    
    private boolean checkVertical(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = rowIndex + 1; i < rowIndex + 4; i++) {
            if (i >= getRow() || grid[i][colIndex] != first) return false;
        }
        return true;
    }
    
    private boolean checkHorizontal(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = colIndex + 1; i < colIndex + 4; i++) {
            if (i >= getCol() || grid[rowIndex][i] != first) return false;
        }
        return true;
    }
    
    private boolean checkDiagonalRight(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = 1; i < 4; i++) {
            if (rowIndex + i >= getRow() || colIndex + i >= getCol() || grid[rowIndex + i][colIndex + i] != first) return false;
        }
        return true;
    }
    
    private boolean checkDiagonalLeft(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = 1; i < 4; i++) {
            if (rowIndex + i >= getRow() || colIndex - i < 0 || grid[rowIndex + i][colIndex - i] != first) return false;
        }
        return true;
    }
    private boolean isGridFull() {
        for (int rowIndex = 0; rowIndex < getRow(); rowIndex++) {
            for (int colIndex = 0; colIndex < getCol(); colIndex++) {
                if (grid[rowIndex][colIndex] == Piece.EMPTY) {
                    return false; // Found an empty spot, so the grid is not full
                }
            }
        }
        return true; // No empty spots found, the grid is full
    }
        
        
}
