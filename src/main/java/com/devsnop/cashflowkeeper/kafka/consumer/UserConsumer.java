package com.devsnop.cashflowkeeper.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.config.KafkaConfig;
import com.devsnop.cashflowkeeper.dto.user.UserDTO;

@Service
public class UserConsumer {

	private static final String GROUP_ID = "myGroup";

	private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);

	@KafkaListener(topics = KafkaConfig.CASH_FLOW_KEEPER_TOPIC, groupId = GROUP_ID, containerFactory = "userKafkaListenerContainerFactory")
	public void userListener(ConsumerRecord<String, UserDTO> record) {
		LOGGER.info("Message received " + record.partition());
		LOGGER.info("Message received " + record.value());
	}
}
