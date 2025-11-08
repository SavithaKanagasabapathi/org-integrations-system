package org.ordering.services.kafka;

import org.ordering.services.model.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class OrderProducer {

	private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

	@Value("${topic.order.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, OrderRequest> kafkaTemplate;

	public void sendOrderEvent(OrderRequest orderRequest) {
		// Publishes the event using the Order ID as the key for partitioning
		kafkaTemplate.send(topicName, orderRequest.getOrderId(), orderRequest);
		logger.info("ORDER PRODUCER: Published OrderEvent with ID: {}", orderRequest.getOrderId());
	}
}