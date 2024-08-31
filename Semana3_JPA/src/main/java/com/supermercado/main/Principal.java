package com.supermercado.main;
import com.supermercado.model;
import com.supermercado.model.Product;
import com.supermercado.model.Product.ProductDAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
public class Principal {

	public static void main(String[] args) {
		 ProductDAO productDAO = new ProductDAO();

	        // Crear un nuevo producto
	        Product product = new Product();
	        product.setName("Orange Juice");
	        product.setCategory("Beverages");
	        product.setPrice(new BigDecimal("2.99"));
	        product.setStock(100);
	        product.setDateAdded(new Date());
	        productDAO.createProduct(product);

	        // Leer un producto
	        Product retrievedProduct = productDAO.findProduct(product.getId());
	        System.out.println("Retrieved Product: " + retrievedProduct.getName() + ", Price: " + retrievedProduct.getPrice());

	        // Actualizar un producto
	        retrievedProduct.setPrice(new BigDecimal("3.50"));
	        productDAO.updateProduct(retrievedProduct);

	        // Leer todos los productos
	        List<Product> products = productDAO.findAll();
	        for (Product p : products) {
	            System.out.println("Product: " + p.getName() + ", Category: " + p.getCategory() + ", Price: " + p.getPrice());
	        }

	        // Eliminar un producto
	        productDAO.deleteProduct(retrievedProduct.getId());

	}

}
