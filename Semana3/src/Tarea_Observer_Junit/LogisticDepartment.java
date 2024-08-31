package Tarea_Observer_Junit;

public class LogisticDepartment implements Observer {
	@Override
    public void update(Product product) {
        System.out.println("Logistics Department notified. New inventory for " + product.getName() + ": " + product.getInventory());
    }
}
