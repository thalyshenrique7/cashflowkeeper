package com.devsnop.cashflowkeeper.docker;

public class HelloDocker {

	private String content;
	private String environment;

	public HelloDocker(String content, String environment) {
		super();
		this.content = content;
		this.environment = environment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
