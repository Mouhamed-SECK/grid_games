package model;

/**
 * Représente un coup dans un jeu de grille.
 * Cette classe stocke les coordonnées d'une action de jeu spécifique, identifiée par une ligne et une colonne.
 */
public class Coup {
    private int row; // La ligne où le coup est joué
    private int col; // La colonne où le coup est joué

    /**
     * Construit un coup avec les coordonnées spécifiées.
     *
     * @param row La ligne où le coup est joué.
     * @param col La colonne où le coup est joué.
     */
    public Coup(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Récupère la ligne où le coup a été joué.
     *
     * @return La ligne du coup.
     */
    public int getRow() {
        return row;
    }

    /**
     * Définit la ligne où le coup est joué.
     *
     * @param row La nouvelle ligne du coup.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Récupère la colonne où le coup a été joué.
     *
     * @return La colonne du coup.
     */
    public int getCol() {
        return col;
    }

    /**
     * Définit la colonne où le coup est joué.
     *
     * @param col La nouvelle colonne du coup.
     */
    public void setCol(int col) {
        this.col = col;
    }
}
