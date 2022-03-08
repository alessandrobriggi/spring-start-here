package it.products.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.products.model.Product;

@Service
public class ProductService {
	
	private List<Product> listProducts = new ArrayList<Product>();
	
	public void addProduct(Product p) {
		listProducts.add(p);
	}
	
	public List<Product> findAll() {
		return listProducts;
	}

}
