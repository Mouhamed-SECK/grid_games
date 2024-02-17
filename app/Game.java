package app;

import controller.GameController;
import controller.IGameController;
import model.IModelJeu;
import model.ModelJeu;
import model.ModelMorpion;
import view.ConsoleView;
import view.IView;

class Game {


    public static void main(String[] args) {
    // Instanciation de la vue
        IView view = new ConsoleView();

        // Instanciation du contrôleur
        IGameController controller = new GameController();

        // Liaison entre la vue et le contrôleur
        view.setController(controller);
     
        // Liaison entre  le contrôleur la vue et
        controller.setView(view);


        // Affichage du menu pour le choix du jeu
        int choixJeu = view.saisirChoixJeu();

        // Instanciation du modèle du jeu en fonction du choix
        ModelJeu modelJeu = null;
        switch (choixJeu) {
            case 1:
                // Instanciation du modèle pour le jeu Tic-Tac-Toe
                System.out.println("Choix morpion.");

                modelJeu = new ModelMorpion(4, 4); // À remplacer par l'instanciation du modèle correspondant
                break;
            case 2:
                // Instanciation du modèle pour le jeu Puissance 4
                System.out.println("Choix puissance 4.");

                // model = new Puissance4Model(); // À remplacer par l'instanciation du modèle correspondant
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }
        view.subscribe(modelJeu);

        controller.setModel(modelJeu);

      
        // Initialisation de la vue
        view.activateView();
        
    }

}