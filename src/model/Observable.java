package model;

/**
 * Interface for the Subject in the Observer pattern.
 */
public interface Observable {
    /**
     * Notifie tous les observateurs en appelant leur méthode update.
     */
    void notifyObservers();

    /**
     * Ajoute un observateur à la liste des observateurs.
     *
     * @param o L'observateur à ajouter.
     */
    void addObserver(Observer o);

    /**
     * Supprime un observateur de la liste des observateurs.
     *
     * @param o L'observateur à supprimer.
     */
    void deleteObserver(Observer o);
}