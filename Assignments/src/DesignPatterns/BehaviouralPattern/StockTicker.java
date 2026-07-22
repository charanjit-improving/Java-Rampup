package src.DesignPatterns.BehaviouralPattern;

import java.util.ArrayList;
import java.util.List;

public class StockTicker  {
    private List<Observer> observers = new ArrayList<>();

    private double price;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
