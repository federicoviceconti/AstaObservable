package model;

/**
 * Created by personale on 14/03/2017.
 */
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
