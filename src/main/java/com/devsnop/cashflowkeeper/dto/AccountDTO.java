package com.devsnop.cashflowkeeper.dto;

import java.math.BigDecimal;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class AccountDTO extends AbstractDTO {

	private Long accountTypeId;

	private BigDecimal balance;

	private Long userId;

	public Long getAccountTypeId() {

		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {

		this.accountTypeId = accountTypeId;
	}

	public BigDecimal getBalance() {

		return balance;
	}

	public void setBalance(BigDecimal balance) {

		this.balance = balance;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

}
