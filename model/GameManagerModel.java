package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for the game manager model.
 */
public class GameManagerModel implements IGameManagerModel, Subject {
    private int row;
    private int column;
    private Piece[][] grid;
    private List<Observer> observers;

    /**
     * Constructor for GameManagerModel.
     *
     * @param row  The number of rows in the grid.
     * @param col  The number of columns in the grid.
     * @param grid The initial grid configuration.
     */
    public GameManagerModel(int row, int col, Piece[][] grid) {
        this.row = row;
        this.column = col;
        this.grid = grid;
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean isGameOver() {
        // Implement game over logic
        return false;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setPlayMove(int row, int col) {
        // Implement play move logic
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public Piece[][] getGrid() {
        return grid;
    }

    @Override
    public void setGrid(Piece[][] grid) {
        this.grid = grid;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }
}
