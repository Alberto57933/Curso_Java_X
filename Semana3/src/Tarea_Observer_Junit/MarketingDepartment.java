package Tarea_Observer_Junit;

public class MarketingDepartment implements Observer {
	@Override
    public void update(Product product) {
        System.out.println("Marketing Department notified. New inventory for " + product.getName() + ": " + product.getInventory());
    }

}
