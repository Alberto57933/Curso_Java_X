package Tarea_Observer_Junit;

public class SalesDepartment implements Observer{

	@Override
	public void update(Product product) {
		System.out.println("Sales Department notified. New inventory for " + product.getName() + ": " + product.getInventory());
	}
	
}
