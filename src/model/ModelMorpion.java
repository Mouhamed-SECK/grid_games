package model;
import controller.GameStatus;

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
    /**
    * Détermine si le jeu est terminé en vérifiant la présence d'une ligne, colonne ou diagonale gagnante  ou si la grille est entièrement remplie.
    * 
    * @return GameStatus Retourne l'état actuel du jeu, soit PLAYER_1_WIN, PLAYER_2_WIN, DRAW, ou IN_PROGRESS.
    */
    @Override
    public GameStatus isGameOver() {
        // Check for a winning line or a full board
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return currentPlayer == Player.CROSS ? GameStatus.PLAYER_1_WIN : GameStatus.PLAYER_2_WIN;
            }
        }
        if (checkDiagonals()) {
            return currentPlayer == Player.CROSS ? GameStatus.PLAYER_1_WIN : GameStatus.PLAYER_2_WIN;
        }
        if (isGridFull()) {
            return GameStatus.DRAW;
        }
        return GameStatus.IN_PROGRESS;
    }
    
    /**
    * Vérifie si une ligne donnée contient une séquence gagnante de pièces identiques.
    * 
    * @param rowIndex L'indice de la ligne à vérifier.
    * @return boolean Vrai si une ligne gagnante est trouvée, faux autrement.
    */
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
    /**
    * Vérifie si une colonne donnée contient une séquence gagnante de pièces identiques.
    * 
    * @param colIndex L'indice de la colonne à vérifier.
    * @return boolean Vrai si une colonne gagnante est trouvée, faux autrement.
    */
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
    /**
    * Vérifie les deux diagonales principales pour une séquence gagnante de pièces identiques.
    * 
    * @return boolean Vrai si une diagonale gagnante est trouvée, faux autrement.
    */
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
    /**
    * Vérifie si la grille de jeu est entièrement remplie de pièces, indiquant qu'il n'y a plus de coups possibles.
    * 
    * @return boolean Vrai si la grille est complètement remplie, faux si des coups sont encore possibles.
    */
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

