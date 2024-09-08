package com.devsnop.cashflowkeeper.enums;

public enum AccountType {

	CURRENT(1L, "Current account"), SAVINGS(2L, "Savings account");

	private AccountType(Long id, String description) {

		this.id = id;
		this.description = description;
	}

	private Long id;

	private String description;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public static AccountType getAccountTypeById(Long accountTypeId) {

		for (AccountType type : AccountType.values())
			if (type.getId().equals(accountTypeId))
				return type;

		return null;
	}

}
