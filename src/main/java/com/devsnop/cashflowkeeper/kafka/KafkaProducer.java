package com.devsnop.cashflowkeeper.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.config.KafkaConfig;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send(KafkaConfig.CASH_FLOW_KEEPER_TOPIC, message);
	}

}
