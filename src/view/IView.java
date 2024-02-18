package view;

import controller.GameStatus;
import controller.IGameController;
import model.Observable;

/**
 * Interface représentant la vue du jeu.
 */
public interface IView {

    /**
     * Initialise la vue du jeu.
     */
    void activateView();

    /**
     * Permet à un joueur de saisir un coup.
     *
     * @return Le coup saisi par le joueur.
     */
    int saisirCoup();

    /**
     * Affiche le menu de choix du jeu et retourne le choix du joueur.
     *
     * @return Le choix du joueur.
     */
    void afficherMenuChoixJeu();

    /**
     * Affiche la grille de jeu.
     */
    void afficherGrid();


     public void subscribe(Observable o);

    /**
     * Affiche le message de fin de partie.
     */
    void afficherGameOver(GameStatus status);

    /**
     * Affiche un message d'erreur pour un coup invalide.
     */
    void afficherErrorCoup();

    /**
     * Définit le contrôleur pour la vue.
     * @param controller Le contrôleur à définir.
     */
    void setController(IGameController IGmeController);


      /**
     * Permet au joueur de saisir son choix de jeu.
     *
     * @return Le choix de jeu du joueur.
     */
    public int saisirChoixJeu();

    /**
     * Affiche le joueur actif avec une couleur.
     * Utilise les codes de couleur ANSI pour afficher les noms des joueurs en rouge ou en bleu.
    */
    public void afficherCurrentPlayer();

    /**
     * Permet au joueur de saisir de poser un coup ou de quitter  .
     *
     * @return Le choix  du joueur soit 1 pour jouer ou 2 pour quitter.
     */
    public int saisirChoix();
}
