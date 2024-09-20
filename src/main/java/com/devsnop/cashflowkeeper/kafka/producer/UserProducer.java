package com.devsnop.cashflowkeeper.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.config.KafkaConfig;
import com.devsnop.cashflowkeeper.dto.user.UserDTO;

@Service
public class UserProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

	private KafkaTemplate<String, UserDTO> kafkaTemplate;

	public UserProducer(KafkaTemplate<String, UserDTO> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(UserDTO userDTO) {
		LOGGER.info("Success");
		this.kafkaTemplate.send(KafkaConfig.CASH_FLOW_KEEPER_TOPIC, userDTO);
		
		
	}

}
