package by.it.academy.app2task;


import java.util.ArrayList;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
