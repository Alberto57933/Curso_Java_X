package Tarea_Observer_Junit;

public class Product {
	private String name;
    private int inventory;

    public Product(String name, int inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
