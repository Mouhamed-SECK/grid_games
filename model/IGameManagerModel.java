package model;

/**
 * Interface for the game manager model.
 */
public interface IGameManagerModel {
    boolean isGameOver();

    int getRow();

    void setPlayMove(int row, int col);

    int getColumn();

    Piece[][] getGrid();

    void setGrid(Piece[][] grid);
}