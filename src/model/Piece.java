package model;

public enum Piece {
    CROSS,
    CIRCLE ,
    EMPTY ;

    /**
     * Retourne le symbole correspondant à la pièce.
     *
     * @return Le symbole de la pièce.
     */
    public String toString() {
        switch (this) {
            case CROSS:
                return "X";
            case CIRCLE:
                return "O";
            case EMPTY:
                return "";
            default:
                throw new IllegalArgumentException();
        }
    }
}
