package Tarea_Observer_Junit;

public class Principal {
	public static void main(String[] args) {
        Product product = new Product("Laptop", 50);

        InventorySystem inventorySystem = new InventorySystem();

        Observer sales = new SalesDepartment();
        Observer marketing = new MarketingDepartment();
        Observer logistics = new LogisticDepartment();

        inventorySystem.addObserver(sales);
        inventorySystem.addObserver(marketing);
        inventorySystem.addObserver(logistics);

        System.out.println("Updating inventory...");
        inventorySystem.updateInventory(product, 30);

        System.out.println("Updating inventory again...");
        inventorySystem.updateInventory(product, 20);
    }

}
