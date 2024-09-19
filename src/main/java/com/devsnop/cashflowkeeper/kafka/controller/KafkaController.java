package com.devsnop.cashflowkeeper.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsnop.cashflowkeeper.kafka.producer.KafkaProducer;

@RestController
@RequestMapping(value = "/api/kafka")
public class KafkaController {

	private KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping(value = "/publish")
	public ResponseEntity<String> publish(@RequestParam(value = "message") String message) {
		this.kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic successfully.");
	}

}
