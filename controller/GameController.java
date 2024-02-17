package controller;

import model.IModelJeu;
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
    
            // Convertir le coup en coordonnées (ligne, colonne)
            int ligne = (coup - 1) / this.model.getRow() ;
            int colonne = (coup - 1) % this.model.getCol() ;

            if (this.verifierCoupValide(model.getGrid(), ligne, colonne)) {
                // Jouer le coup dans le modèle
                this.model.jouerCoup(ligne, colonne);
    

            } else {
                this.view.saisirChoix();
            }
    
            
            // Vérifier si la partie est terminée
            if (this.model.isGameOver()) {
                this.view.afficherGameOver();
            } else {
                // Changer de joueur actif
                this.model.changeCurrentPlayer();
            }
        } catch (Exception e) {
            // Afficher une erreur si le coup n'est pas valide
            this.view.afficherErrorCoup();
        }
    }


    public boolean verifierCoupValide (Piece[][] grid, int row, int col) {
       return  this.coupValidStrategy.verifierCoupValide(grid, row, col);
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    public IModelJeu getModel() {
        return model;
    }

    public void setModel(IModelJeu model) {
        this.model = model;
    }


    public void setCoupValidStrategy(CoupValidStrategy coupValidStrategy) {
        this.coupValidStrategy = coupValidStrategy;
    }


   
}
