package com.empowerfit.app.controller;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empowerfit.app.model.OrderHasProduct;
import com.empowerfit.app.service.OrderHasProductService;



@RestController
@RequestMapping("api/v1/purchases-has-products")
@CrossOrigin(origins = "*")
public class OrderHasProductController {

	OrderHasProductService orHprService;

	public OrderHasProductController(OrderHasProductService orHprService) {
		this.orHprService = orHprService;
	}
	
	
	@PostMapping
	public ResponseEntity<OrderHasProduct> createOrderHasProduct(@RequestBody OrderHasProduct orderHasProducts) {
		OrderHasProduct savedOrderHasProduct = orHprService.createOrderHasProduct(orderHasProducts);
		return ResponseEntity.status(201).body(savedOrderHasProduct);
	}
		
	@GetMapping
	public ResponseEntity< Iterable<OrderHasProduct>> getAllOrderHasProducts() {
		Iterable<OrderHasProduct> orderHasProducts = orHprService.getOrderHasProducts();
		return ResponseEntity.ok(orderHasProducts);
	}
	
	@GetMapping("/query") // localhost:8080/api/v1/purchases-has-products/query?purchaseId=1&productId=3 
	public ResponseEntity< OrderHasProduct> getOrderHasProductByCompositeId(
			@RequestParam(name = "orderId") Long orderId,
			@RequestParam(name = "productId") Long productId
			) {
		OrderHasProduct orderHasProduct = orHprService.getOrderHasProductByCompositeId(orderId, productId);
		return ResponseEntity.ok(orderHasProduct);
	}
	
	@GetMapping("/order/{id}") // localhost:8080/api/v1/order-has-products/order/1
	public ResponseEntity< Set<OrderHasProduct>> getOrderHasProductsByOrderId(
			@PathVariable("id") Long orderId
			) {
		Set<OrderHasProduct> orderHasProduct = orHprService.getOrderHasProductsByOrderId(orderId);
		return ResponseEntity.ok(orderHasProduct);
	}
}
