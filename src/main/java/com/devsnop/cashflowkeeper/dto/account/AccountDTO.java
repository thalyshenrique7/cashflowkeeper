package com.devsnop.cashflowkeeper.dto.account;

import java.math.BigDecimal;

import com.devsnop.cashflowkeeper.enums.AccountType;
import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class AccountDTO extends AbstractDTO {

	private AccountType accountType;

	private Long userId;
	private Long categoryId;

	private BigDecimal initialBalance = BigDecimal.ZERO;

	private boolean active = true;
	private boolean deleted = false;

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
