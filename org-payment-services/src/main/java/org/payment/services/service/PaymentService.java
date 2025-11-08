package org.payment.services.service;

import org.ordering.services.model.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public void processPayment(OrderRequest order) {

		// 1. Perform External Call like 3rd party payment gateway

		// 2. Save the completed payment record to the dedicated 'Payment' database.

		// 3. Publish a new event back to Kafka so Inventory, Shipping etc., can react.
	}
}