package Tarea_Observer_Junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventorySystemTest {
	private InventorySystem inventorySystem;
    private TestObserver testObserver;
    private Product product;

    @BeforeEach
    void setUp() {
        inventorySystem = new InventorySystem();
        testObserver = new TestObserver();
        product = new Product("Smartphone", 100);
        inventorySystem.addObserver(testObserver);
    }

    @Test
    void testObserverIsNotified() {
        inventorySystem.updateInventory(product, 80);
        assertEquals(80, testObserver.getLastInventory());
    }

    // Clase interna para pruebas
    private class TestObserver implements Observer {
        private int lastInventory;

        @Override
        public void update(Product product) {
            this.lastInventory = product.getInventory();
        }

        public int getLastInventory() {
            return lastInventory;
        }
    }
}
