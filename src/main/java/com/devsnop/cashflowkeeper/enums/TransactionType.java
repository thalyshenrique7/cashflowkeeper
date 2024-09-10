package com.devsnop.cashflowkeeper.enums;

public enum TransactionType {

	TRANSFER("Transfer"), DEPOSIT("Deposit"), WITHDRAW("Withdraw");

	private String description;

	private TransactionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
