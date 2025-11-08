package org.ordering.services.controller;

import org.ordering.services.model.OrderRequest;
import org.ordering.services.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderDomainService;

	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {

		String orderId = orderDomainService.createAndPublishOrder(orderRequest);

		return ResponseEntity.accepted().body("Order received and payment processing initiated for ID: " + orderId);
	}
}