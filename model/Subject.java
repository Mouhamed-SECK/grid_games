package model;

/**
 * Interface for the Subject in the Observer pattern.
 */
public interface Subject {
    void notifyObservers();

    void addObserver(Observer o);

    void deleteObserver(Observer o);
}