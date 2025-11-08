package org.ordering.services.service;

import java.util.UUID;

import org.ordering.services.kafka.OrderProducer;
import org.ordering.services.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderProducer orderProducer;

	public static final String PENDING_STATUS = "PENDING_PAYMENT";

	public String createAndPublishOrder(OrderRequest request) {
		String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
		request.setOrderId(orderId);

		// Save to DB with PENDING status (Transactional)

		orderProducer.sendOrderEvent(request);

		return orderId;
	}
}