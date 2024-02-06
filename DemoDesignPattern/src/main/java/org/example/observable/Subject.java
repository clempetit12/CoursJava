package org.example.observable;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers(Weather weather);

}
