package com.devsnop.cashflowkeeper.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.config.KafkaConfig;

@Service
public class KafkaConsumer {

	private static final String GROUP_ID = "myGroup";

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = KafkaConfig.CASH_FLOW_KEEPER_TOPIC, groupId = GROUP_ID)
	public void consume(String message) {
		LOGGER.info(String.format("Message received %s", message));
	}
}
