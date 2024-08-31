package Tarea_Observer_Junit;

import java.util.ArrayList;
import java.util.List;

public class InventorySystem {
	private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Product product) {
        for (Observer observer : observers) {
            observer.update(product);
        }
    }

    public void updateInventory(Product product, int newInventory) {
        product.setInventory(newInventory);
        notifyObservers(product);
    }
}
