package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.IGameController;
import controller.GameStatus;

/**
 * Classe de base pour le modèle du gestionnaire de jeu.
 */
public abstract class ModelJeu implements  IModelJeu, Observable {

    private int row;
    private Coup coupProposed;
    private int col;
    protected Piece[][] grid;
    private List<Observer> observers;
    protected Player currentPlayer;
    private IGameController controller; // Lien avec le contrôleur

    /**
     * Constructeur pour le modèle du jeu.
     *
     * @param row  Le nombre de lignes dans la grille.
     * @param col  Le nombre de colonnes dans la grille.
     */
    public ModelJeu(int row, int col) {
        this.row = row;
        this.col = col;
        this.observers = new ArrayList<>();
        this.initGrid();

        // Générer un nombre aléatoire entre 0 et 1 inclus pour décider de qui commence
        currentPlayer = (new Random().nextInt(2) == 0) ? Player.CROSS : Player.CIRCLE;
    }

    /**
     * Initialise la grille du jeu.
     */
    public void initGrid() {
        Piece[][] grid = new Piece[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = Piece.EMPTY;
            }
        }
        this.grid = grid;
    }

    /**
     * Vérifie si le jeu est terminé.
     *
     * @return Vrai si le jeu est terminé, sinon faux.
     */
    public abstract GameStatus isGameOver();

    /**
     * Récupère le nombre de lignes dans la grille.
     *
     * @return Le nombre de lignes.
     */
    public int getRow() {
        return row;
    }

    /**
     * Récupère le nombre de colonnes dans la grille.
     *
     * @return Le nombre de colonnes.
     */
    public int getCol() {
        return col;
    }

    /**
     * Méthode alternative pour jouer un coup.
     */
    public void jouerCoup() {
        int row = this.coupProposed.getRow();
        int col = this.coupProposed.getCol();

        this.grid[row][col] = currentPlayer == Player.CROSS ? Piece.CROSS : Piece.CIRCLE;
        this.notifyObservers();
    }

    /**
     * Définit la grille du jeu.
     *
     * @param grid La nouvelle grille du jeu.
     */
    public void setGrid(Piece[][] grid) {
        this.grid = grid;
        notifyObservers();
    }

    /**
     * Méthode pour changer le joueur en cours.
     */
    public void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.CROSS) ? Player.CIRCLE : Player.CROSS;
    }

    /**
     * Notifie tous les observateurs en appelant leur méthode update.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Ajoute un observateur à la liste des observateurs.
     *
     * @param o L'observateur à ajouter.
     */
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Supprime un observateur de la liste des observateurs.
     *
     * @param o L'observateur à supprimer.
     */
    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Obtient la grille de jeu actuelle.
     *
     * @return La grille de jeu représentée par un tableau de pièces.
     */
    @Override
    public Piece[][] getGrid() {
        return grid;
    }

    /**
     * Définit le contrôleur associé à ce modèle.
     *
     * @param controller Le contrôleur à associer.
     */
    public void setController(IGameController controller) {
        this.controller = controller;
    }

    /**
     * Définit le joueur actif.
     *
     * @param currentPlayer Le joueur actif à définir.
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Récupère le joueur actif.
     *
     * @return Le joueur actif.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    /**
     * Obtient le coup proposé actuellement par le joueur.
     *
     * @return Le coup proposé.
     */
    public Coup getCoupProposed() {
        return coupProposed;
    }
    /**
     * Définit le coup proposé par le joueur.
     *
     * @param coupProposed Le coup à proposer.
     */
    public void setCoupProposed(Coup coupProposed) {
        this.coupProposed = coupProposed;
    }

}
