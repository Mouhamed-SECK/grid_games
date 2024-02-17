package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Observer;
import model.Piece;
import model.Player;
import controller.IGameController;
import model.Observable;

/**
 * Classe représentant la vue du jeu dans la console.
 */
public class ConsoleView implements IView, Observer {
    private Scanner scanner;
    private IGameController controller;

    /**
     * Constructeur de la classe ConsoleView.
     *
     * @param controller Le contrôleur associé à la vue.
     */
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
       
    }

    /**
     * S'abonne à un sujet en ajoutant l'observateur à la liste des observateurs du sujet.
     *
     * @param o Le sujet auquel s'abonner.
     */
    public void subscribe(Observable o) {
        o.addObserver(this);
    }

    /**
     * Active la vue du jeu en affichant la grille, le joueur actuel, et en traitant les choix de l'utilisateur.
     * La boucle continue tant que la partie n'est pas terminée et que l'utilisateur ne choisit pas de quitter.
     */
    @Override
    public void activateView() {
        // Initialisation de la vue du jeu
        this.afficherGrid();
        int choix;

        do {
            
            // Afficher le joueur qui doit jouer
            this.afficherCurrentPlayer();
            
            // Afficher le menu de choix
            this.afficherMenu();
            
            // Demander à l'utilisateur de faire un choix
             choix = this.saisirChoix();
            
            // Traiter le choix de l'utilisateur
            this.traiterChoixUtilisateur(choix);
            
            // Mettre à jour la vue après le choix de l'utilisateur
      
        } while (!this.controller.getModel().isGameOver() && choix != 2);
    }

    /**
     * Demande à l'utilisateur de saisir une case et retourne la valeur saisie.
     *
     * @return La case saisie par l'utilisateur.
     */
    @Override
    public int saisirCoup() {
        System.out.print("Saisir la case  : ");
        int coup = scanner.nextInt();
        return coup;
    }

    /**
     * Affiche le menu de choix du jeu.
     */
    @Override
    public void afficherMenuChoixJeu() {
        // Couleur cyan pour l'en-tête du menu
        System.out.print("\u001B[36m");
        System.out.println("+----------------------------------------+");
        System.out.println("|              MENU DE JEU               |");
        System.out.println("+----------------------------------------+");
        System.out.println("| 1. TIC-TAC-TOE                         |");
        System.out.println("| 2. PUISSANCE 4                         |");
        System.out.println("+----------------------------------------+");
        // Réinitialisation de la couleu
        System.out.print("\u001B[0m");
        System.out.println("Choisir un jeu \n");
    }

    /**
     * Affiche le menu de choix pour le joueur.
     */
    public void afficherMenu() {
    // Affichage du menu sur une seule ligne avec des éléments colorés
        System.out.println("\nMenu de choix : ");
        System.out.println();
        System.out.print("\u001B[36m1. Jouer \u001B[0m \t");
        System.out.print("\u001B[36m2. Quitter \u001B[0m \t");
        System.out.println("\tVeuillez choisir une option : ");
    }

    /**
     * Affiche le message de fin de partie.
     */
    @Override
    public void afficherGameOver() {
        // Affichage du message de fin de partie
    }

    /**
     * Affiche un message d'erreur pour un coup invalide.
     */
    @Override
    public void afficherErrorCoup() {
        System.out.println("Coup invalide. Veuillez réessayer.");
    }

    /**
     * Met à jour la vue en affichant la grille après un changement.
     */
    @Override
    public void update() {
        this.afficherGrid();
    }

    /**
     * Définit le contrôleur associé à la vue.
     *
     * @param controller Le contrôleur à associer.
     */
    @Override
    public void setController(IGameController controller) {
        this.controller = controller;
    }

    /**
     * Permet au joueur de saisir son choix de jeu.
     *
     * @return Le choix de jeu du joueur.
     */
    public int saisirChoixJeu() {
        int choix;
        do {
            afficherMenuChoixJeu();
            choix = scanner.nextInt();
        } while (choix != 1 && choix != 2);
        return choix;
    }

    /**
     * Affiche la grille de jeu avec les symboles des pièces et les numéros de case.
     */
    @Override
    public void afficherGrid() {
        Piece[][] grille = this.controller.getModel().getGrid();
    
        int rowLength = grille.length;
        int colLength = grille[0].length;
    
        System.out.println();
        System.out.print("      ");
        System.out.print("+");
    
        // Boucle pour afficher chaque ligne de la grille
        for (int i = 0; i < colLength; i++) {
            System.out.print("----+");
        }
        System.out.print("\n");
    
        for (int i = 0; i < rowLength; ++i) {
            System.out.print("      ");
            System.out.print("|");
    
            for (int j = 0; j < colLength; ++j){
                Piece piece = grille[i][j];
                String symbole = "";
                String couleur = "\u001B[0m"; // Couleur par défaut (reset)
    
                // Obtention du symbole de la case
                if (piece == Piece.EMPTY) {
                    symbole = Integer.toString(i * colLength + j + 1); // Numéro de case
                } else {
                    symbole = piece.toString(); // Symbole du joueur
                    couleur = (piece == Piece.CROSS) ? "\u001B[31m" : "\u001B[34m"; // Rouge pour CROSS, Bleu pour CIRCLE
                }
                
                // Formater correctement le symbole pour l'alignement
                String formattedSymbol = String.format("%3s", symbole); // 3 caractères pour l'alignement
                
                System.out.print(couleur + formattedSymbol + " \u001B[0m|");
            }
            System.out.println();
            System.out.print("      ");
            System.out.print("+");
    
            // Boucle pour afficher chaque ligne de la grille
            for (int k = 0; k < colLength; k++) {
                System.out.print("----+");
            }
    
            System.out.print("\n");
        }
    }
    

     /**
     * Affiche le joueur actif avec une couleur.
     * Utilise les codes de couleur ANSI pour afficher les noms des joueurs en rouge ou en bleu.
     */
    @Override
    public void afficherCurrentPlayer() {
        // Définir les couleurs pour chaque joueur
        Map<Player, String> colors = new HashMap<>();
        colors.put(Player.CROSS, "\u001B[31m"); // Rouge
        colors.put(Player.CIRCLE, "\u001B[34m"); // Bleu

        // Afficher le joueur actif avec sa couleur respective
        Player currentPlayer = this.controller.getModel().getCurrentPlayer();
        System.out.println("\nC'est à " + colors.get(currentPlayer) + currentPlayer + "\u001B[0m de jouer :");
    }

    /**
     * Demande à l'utilisateur de saisir un choix et retourne la valeur saisie.
     *
     * @return Le choix saisi par l'utilisateur.
     */
    @Override
    public int saisirChoix() {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.print("Entrez votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre : ");
                scanner.next();
            }
            choix = scanner.nextInt();
        } while (choix < 1 || choix > 2);
        return choix;
    }


    /**
     * Traite le choix de l'utilisateur.
     *
     * @param choix Le choix de l'utilisateur.
     */
    public void traiterChoixUtilisateur(int choix) {
        switch (choix) {
            case 1:
                this.controller.gererSaisie();
                break;
            case 2:
                // L'utilisateur choisit de quitter le jeu
                System.out.println("\nVous avez choisi de quitter le jeu. Au revoir !");
                // Sortir de la boucle do-while et terminer le jeu
                break;
            default:
                // Choix invalide
                System.out.println("\nChoix invalide. Veuillez choisir une option valide.");
                break;
        }
    }
}
