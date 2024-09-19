package com.devsnop.cashflowkeeper.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	public static final String CASH_FLOW_KEEPER_TOPIC = "cashFlowKeeper";

	@Bean
	public NewTopic cashFlowKeeperTopic() {

		return TopicBuilder.name(CASH_FLOW_KEEPER_TOPIC).build();
	}
}
