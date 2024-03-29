package model;

import controller.IGameController;
import controller.GameStatus;

/**
 * Interface for the game manager model.
 */
public interface IModelJeu {
    /**
     * Initialise la grille du jeu.
     */
    void initGrid();

    /**
     * Vérifie si le jeu est terminé.
     *
     * @return l'état du jeu.
     */
    public GameStatus isGameOver();


    /**
     * Effectue le mouvement d'un joueur.
     *
     * @param row La ligne du mouvement.
     * @param col La colonne du mouvement.
     */
    void jouerCoup();

    /**
     * Permet de recuperer la grille 
     */
    Piece[][]  getGrid();

    /**
     * Méthode pour changer le joueur en cours.
     */
    void changeCurrentPlayer();

    /**
     * Ajoute un observateur au modèle.
     *
     * @param o L'observateur à ajouter.
     */
    void addObserver(Observer o);

    /**
     * Supprime un observateur du modèle.
     *
     * @param o L'observateur à supprimer.
     */
    void deleteObserver(Observer o);

     /**
     * Définit le contrôleur associé à ce modèle.
     *
     * @param controller Le contrôleur à associer.
     */
    void setController(IGameController controller);


     /**
     * Définit le joueur actif.
     *
     * @param currentPlayer Le joueur actif à définir.
     */
    public void setCurrentPlayer(Player currentPlayer);



     /**
     * Récupère le joueur actif.
     *
     * @return Le joueur actif.
     */
    public Player getCurrentPlayer();


    /**
     * Récupère le nombre de lignes dans la grille.
     *
     * @return Le nombre de lignes.
     */
    public int getRow();


    /**
     * Récupère le nombre de colonnes dans la grille.
     *
     * @return Le nombre de colonnes .
     */
    public int getCol();


     /**
     * Notifie tous les observateurs en appelant leur méthode update.
     */
    public void notifyObservers();


    public Coup getCoupProposed();


    public void setCoupProposed(Coup coupProposed) ;

}