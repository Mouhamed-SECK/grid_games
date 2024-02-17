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

    public void setModel(IModelJeu model);

    public IModelJeu getModel();

    public void setCoupValidStrategy(CoupValidStrategy coupValidStrategy);

    
}
