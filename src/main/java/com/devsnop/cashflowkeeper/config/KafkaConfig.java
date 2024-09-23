package com.devsnop.cashflowkeeper.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.devsnop.cashflowkeeper.dto.user.UserDTO;

@Configuration
public class KafkaConfig {

	public static final String CASH_FLOW_KEEPER_TOPIC = "cashFlowKeeper";
	public static final String BOOTSTRAP_SERVERS = "localhost:9092";
	public static final String GROUP_ID = "myGroup";
	// public static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";

	@Bean
	public NewTopic createTopic() {

		return new NewTopic(CASH_FLOW_KEEPER_TOPIC, 3, (short) 1);
	}

	@Bean
	public ProducerFactory<String, UserDTO> userProducerFactory() {

		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		// configProps.put("schema.registry.url", SCHEMA_REGISTRY_URL);
		return new DefaultKafkaProducerFactory<String, UserDTO>(configProps);
	}

	@Bean
	public ConsumerFactory<String, UserDTO> userConsumerFactory() {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//		props.put("schema.registry.url", SCHEMA_REGISTRY_URL);
//		props.put("specific.avro.reader", true);
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(UserDTO.class, false));
	}

	@Bean
	public KafkaTemplate<String, UserDTO> userKafkaTemplate() {
		return new KafkaTemplate<>(userProducerFactory());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserDTO> userKafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, UserDTO> factory = new ConcurrentKafkaListenerContainerFactory<String, UserDTO>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}
}
