package com.devsnop.cashflowkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.devsnop.cashflowkeeper.repository")
public class CashFlowKeeperApplication {

	public static void main(String[] args) {

		SpringApplication.run(CashFlowKeeperApplication.class, args);
	}

}
