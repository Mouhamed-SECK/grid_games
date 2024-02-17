package controller;

import model.IModelJeu;
import view.IView;

/**
 * Interface représentant le contrôleur du jeu.
 */
public interface IGameController {

    /**
     * Gère la saisie d'un mouvement par le joueur.
     */
    void gererSaisie();

    /**
     * Définit la vue associée à ce contrôleur.
     *
     * @param view La vue à associer.
     */
    void setView(IView view);

    /**
     * Définit le modèle de jeu associé à ce contrôleur.
     *
     * @param model Le modèle de jeu à associer.
     */
    public void setModel(IModelJeu model);

    /**
     * Obtient le modèle de jeu associé à ce contrôleur.
     *
     * @return Le modèle de jeu associé.
     */
    public IModelJeu getModel();

    /**
     * Définit la stratégie de validation des coups associée à ce contrôleur.
     *
     * @param coupValidStrategy La stratégie de validation des coups à associer.
     */
    public void setCoupValidStrategy(CoupValidStrategy coupValidStrategy);    
}
