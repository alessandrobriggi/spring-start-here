package it.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.products.model.Product;
import it.products.services.ProductService;

@Controller
public class ProductController {
	
	private ProductService productService;
	
//	@Autowired can be omitted since we have only 1 constructor in the class
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public String viewAllProducts(Model page) {
		return goHome(page);
	}
	
	@PostMapping("/products")
	public String addProduct(Product product, Model page) {
		productService.addProduct(product);
		return goHome(page);
	}
	
	private String goHome(Model page) {
		page.addAttribute("listProducts", productService.findAll());
		page.addAttribute("product", new Product());
		return "products.html";
	}
	
}
