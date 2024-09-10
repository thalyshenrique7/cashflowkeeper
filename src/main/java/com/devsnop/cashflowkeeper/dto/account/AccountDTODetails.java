package com.devsnop.cashflowkeeper.dto.account;

import java.math.BigDecimal;

public class AccountDTODetails {

	private String accountTypeDescription;
	private String categoryTypeDescription;
	private String categoryName;

	private BigDecimal balance;

	public String getAccountTypeDescription() {
		return accountTypeDescription;
	}

	public void setAccountTypeDescription(String accountTypeDescription) {
		this.accountTypeDescription = accountTypeDescription;
	}

	public String getCategoryTypeDescription() {
		return categoryTypeDescription;
	}

	public void setCategoryTypeDescription(String categoryTypeDescription) {
		this.categoryTypeDescription = categoryTypeDescription;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
