package controller;

import model.Coup;
import model.IModelJeu;
import model.ModelMorpion;
import model.ModelPuissance4;
import model.Piece;
import view.IView;

/**
 * Classe représentant le contrôleur du jeu.
 */
public class GameController implements IGameController {
    private IView view;
    private IModelJeu model;
    private  CoupValidStrategy coupValidStrategy;
   
    /**
     * Constructeur de la classe GameController.
     *
     * @param view  La vue associée à ce contrôleur.
     * @param model Le modèle de jeu associé à ce contrôleur.
     */
    public GameController(IView view, IModelJeu model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Constructeur de la classe GameController.
     */
    public GameController() {
    }

    @Override
    public void gererSaisie() {
        try {
            // Saisir le coup depuis la vue
            int coup = this.view.saisirCoup();
            // Vérifier la validité du coup
            this.verifierCoupValide(model.getGrid(), coup);
            
            // Jouer le coup dans le modèle
            this.model.jouerCoup();

            // Vérifier l'état de la partie après le coup
            GameStatus status = this.model.isGameOver();
            switch (status) {
                case PLAYER_1_WIN:
                case PLAYER_2_WIN:
                case DRAW:
                    this.view.afficherGameOver(status);
                    break;
                case IN_PROGRESS:
                    // Changer de joueur actif
                    this.model.changeCurrentPlayer();
                    break;
            }
        } catch (Exception e) {
            // Afficher une erreur si le coup n'est pas valide
            this.view.afficherErrorCoup();
            this.model.notifyObservers();
        }
    }



    /**
     * Vérifie si un coup est valide en utilisant la stratégie spécifiée.
     *
     * @param grid La grille de jeu représentée par un tableau de pièces.
     * @param row  La ligne où le coup est proposé.
     * @param col  La colonne où le coup est proposé.
     * @return true si le coup est valide, false sinon.
     */
    public void verifierCoupValide (Piece[][] grid, int coup)  throws Exception{
        Coup  valideCoup = this.coupValidStrategy.verifierCoupValide(grid,  coup);
        this.model.setCoupProposed(valideCoup);
    }

    /**
     * Définit la vue associée à ce contrôleur.
     *
     * @param view La vue à associer.
     */
    @Override
    public void setView(IView view) {
        this.view = view;
    }

    /**
     * Obtient le modèle de jeu associé à ce contrôleur.
     *
     * @return Le modèle de jeu associé.
     */
    public IModelJeu getModel() {
        return model;
    }

    /**
     * Définit le modèle de jeu associé à ce contrôleur.
     *
     * @param model Le modèle de jeu à associer.
     */
    public void setModel(IModelJeu model) {
        this.model = model;
    }

    /**
     * Définit la stratégie de validation des coups associée à ce contrôleur.
     *
     * @param coupValidStrategy La stratégie de validation des coups à associer.
     */
    public void setCoupValidStrategy(CoupValidStrategy coupValidStrategy) {
        this.coupValidStrategy = coupValidStrategy;
    }
}
