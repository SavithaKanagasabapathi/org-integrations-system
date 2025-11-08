package org.payment.services.kafka;

import org.ordering.services.model.OrderRequest;
import org.payment.services.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class PaymentConsumer {

	private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);

	@Autowired
	private PaymentService service;

	@KafkaListener(topics = "${topic.order.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void handleOrderEvent(OrderRequest order) {
		logger.info("PAYMENT CONSUMER: Received OrderEvent with ID: {}", order.getOrderId());
		service.processPayment(order);
	}
}