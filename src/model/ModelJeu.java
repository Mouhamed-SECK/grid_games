package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.IGameController;

/**
 * Classe de base pour le modèle du gestionnaire de jeu.
 */
public class ModelJeu implements IModelJeu, Observable {
    private int row;
    private int col;
    private Piece[][] grid;
    private List<Observer> observers;
    private  Player currentPlayer;

    private IGameController controller; // Lien avec le contrôleur

    /**
     * Constructeur pour le modèle du jeu.
     *
     * @param row  Le nombre de lignes dans la grille.
     * @param col  Le nombre de colonnes dans la grille.
     * @param grid La configuration initiale de la grille.
     */
    public ModelJeu(int row, int col) {
        this.row = row;
        this.col = col;
        this.observers = new ArrayList<>();
        this.initGrid();

         // Générer un nombre aléatoire entre 0 et 1 inclus pour decider de qui commence 
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
    public boolean isGameOver() {
        // Implémenter la logique de fin de jeu
        // TODO need to be define pour les deux jeux  transformer en abstract chaque sous classe donne sa maniére de verifier 
        return false;
    }

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
     * @return Le nombre de colonnes .
     */
    public int getCol() {
        return row;
    }



    /**
     * Méthode alternative pour jouer un coup.
     *
     * @param row La ligne du mouvement.
     * @param col La colonne du mouvement.
     */
    public void jouerCoup(int row, int col ) {
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
     * Trouve la première ligne vide dans une colonne spécifiée.
     *
     * @param col La colonne où rechercher la première ligne vide.
     * @return L'index de la première ligne vide dans la colonne.
     * @throws IllegalArgumentException Si la colonne est pleine.
     */
    public int trouverEmptyRow(int col) {
        Piece[][] grid = this.getGrid();
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][col] == Piece.EMPTY) {
                return row;
            }
        }
        throw new IllegalArgumentException("La colonne est pleine.");
    }
    

   

}
