package com.devsnop.cashflowkeeper.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

	@GetMapping(value = "/hello-docker")
	public HelloDocker getHelloDocker() {

		String hostname = System.getenv("HOSTNAME");

		return new HelloDocker("Hello Docker", hostname);
	}
}
