package it.datasource.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.datasource.model.Purchase;
import it.datasource.repository.PurchaseRepository;

@RestController
public class PurchaseController {

	private final PurchaseRepository purchaseRepository;

	public PurchaseController(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	@PostMapping("/add")
	public void storePurchase(@RequestBody Purchase purchase) {
		purchaseRepository.storePurchase(purchase);
	}

	@GetMapping("/all")
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

}
