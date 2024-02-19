package model;

import controller.IGameController;
import controller.GameStatus;

/**
 * Interface définissant le modèle de gestion de jeu. Elle spécifie les opérations essentielles
 * que le modèle de jeu doit implémenter pour interagir avec le contrôleur et la vue dans l'architecture MVC.
 */
public interface IModelJeu {

    /**
     * Initialise la grille de jeu à son état de départ, généralement vide.
     */
    void initGrid();

    /**
     * Vérifie l'état actuel du jeu pour déterminer s'il est terminé et dans quel état.
     *
     * @return L'état actuel du jeu sous forme de GameStatus.
     */
    GameStatus isGameOver();

    /**
     * Exécute le coup d'un joueur en mettant à jour la grille du jeu en conséquence.
     */
    void jouerCoup();

    /**
     * Fournit la grille de jeu actuelle.
     *
     * @return La grille actuelle du jeu sous forme d'un tableau bidimensionnel de pièces.
     */
    Piece[][] getGrid();

    /**
     * Change le joueur actuel pour passer au joueur suivant.
     */
    void changeCurrentPlayer();

    /**
     * Ajoute un observateur à la liste des observateurs du modèle.
     *
     * @param o L'observateur à ajouter.
     */
    void addObserver(Observer o);

    /**
     * Supprime un observateur de la liste des observateurs du modèle.
     *
     * @param o L'observateur à supprimer.
     */
    void deleteObserver(Observer o);

    /**
     * Associe un contrôleur au modèle.
     *
     * @param controller Le contrôleur à associer au modèle.
     */
    void setController(IGameController controller);

    /**
     * Définit le joueur actuellement actif dans le jeu.
     *
     * @param currentPlayer Le joueur actif à définir.
     */
    void setCurrentPlayer(Player currentPlayer);

    /**
     * Récupère le joueur actuellement actif.
     *
     * @return Le joueur actif.
     */
    Player getCurrentPlayer();

    /**
     * Obtient le nombre de lignes de la grille de jeu.
     *
     * @return Le nombre de lignes dans la grille.
     */
    int getRow();

    /**
     * Obtient le nombre de colonnes de la grille de jeu.
     *
     * @return Le nombre de colonnes dans la grille.
     */
    int getCol();

    /**
     * Notifie tous les observateurs d'un changement d'état en appelant leur méthode de mise à jour.
     */
    void notifyObservers();

    /**
     * Obtient le coup proposé actuellement par le joueur.
     *
     * @return Le coup proposé.
     */
    Coup getCoupProposed();

    /**
     * Définit le coup proposé par le joueur.
     *
     * @param coupProposed Le coup à proposer.
     */
    void setCoupProposed(Coup coupProposed);
}
