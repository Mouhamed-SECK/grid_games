package model;

/**
 * Interface for the Observer in the Observer pattern.
 */
public interface Observer {
    /**
     * Méthode appelée pour informer l'observateur d'un changement dans le sujet observé.
     */
    void update();
}