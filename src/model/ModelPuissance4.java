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
     */
    public ModelPuissance4(int row, int col) {
        super(row, col);
    }
    /**
    * Détermine l'état actuel du jeu en vérifiant toutes les directions possibles
    * pour une ligne gagnante. Cette méthode doit être appelée après chaque coup pour
    * évaluer si la partie est terminée.
    * 
    * @return GameStatus L'état actuel du jeu, pouvant être PLAYER_1_WIN, PLAYER_2_WIN,
    *         DRAW, ou IN_PROGRESS.
    */
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
    
    /**
    * Vérifie s'il y a une ligne verticale de pièces identiques à partir d'une position donnée.
    * 
    * @param rowIndex L'indice de la ligne de départ pour la vérification.
    * @param colIndex L'indice de la colonne de départ pour la vérification.
    * @return boolean Vrai si une ligne verticale est trouvée, faux sinon.
     */
    private boolean checkVertical(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = rowIndex + 1; i < rowIndex + 4; i++) {
            if (i >= getRow() || grid[i][colIndex] != first) return false;
        }
        return true;
    }
    /**
    * Vérifie s'il y a une ligne horizontale de pièces identiques à partir d'une position donnée.
    * 
    * @param rowIndex L'indice de la ligne où la vérification est effectuée.
    * @param colIndex L'indice de la colonne de départ pour la vérification.
    * @return boolean Vrai si une ligne horizontale est trouvée, faux sinon.
    */
    private boolean checkHorizontal(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = colIndex + 1; i < colIndex + 4; i++) {
            if (i >= getCol() || grid[rowIndex][i] != first) return false;
        }
        return true;
    }
    /**
    * Vérifie s'il y a une diagonale droite de pièces identiques à partir d'une position donnée.
    * 
    * @param rowIndex L'indice de la ligne de départ pour la vérification.
    * @param colIndex L'indice de la colonne de départ pour la vérification.
    * @return boolean Vrai si une diagonale droite est trouvée, faux sinon.
    */
    private boolean checkDiagonalRight(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = 1; i < 4; i++) {
            if (rowIndex + i >= getRow() || colIndex + i >= getCol() || grid[rowIndex + i][colIndex + i] != first) return false;
        }
        return true;
    }
    /**
    * Vérifie l'existence d'une diagonale gauche de pièces identiques à partir d'une position donnée.
    *
    * @param rowIndex L'indice de la ligne où commence la vérification.
    * @param colIndex L'indice de la colonne où commence la vérification.
    * @return boolean Vrai si une diagonale gauche est trouvée, faux autrement.
    */
    private boolean checkDiagonalLeft(int rowIndex, int colIndex) {
        Piece first = grid[rowIndex][colIndex];
        for (int i = 1; i < 4; i++) {
            if (rowIndex + i >= getRow() || colIndex - i < 0 || grid[rowIndex + i][colIndex - i] != first) return false;
        }
        return true;
    }
    /**
    * Vérifie si la grille de jeu est entièrement remplie sans aucun espace vide.
     * Cette méthode peut être utilisée pour déterminer si un match nul est survenu lorsque la grille est pleine.
    *
    * @return boolean Vrai si la grille est pleine, faux autrement.
    */
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
