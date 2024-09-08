package com.devsnop.cashflowkeeper.dto.account;

import java.math.BigDecimal;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class AccountDTO extends AbstractDTO {

	private Long accountTypeId;
	private Long userId;
	private Long categoryId;

	private BigDecimal balance;

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
