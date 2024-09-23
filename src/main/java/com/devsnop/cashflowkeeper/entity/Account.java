package com.devsnop.cashflowkeeper.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.enums.AccountType;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private BigDecimal initialBalance = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	private boolean active = true;

	private boolean deleted = false;

	private BigDecimal balance;

	public AccountType getAccountType() {

		return accountType;
	}

	public void setAccountType(AccountType accountType) {

		this.accountType = accountType;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public void deleted() {

		this.setActive(false);
		this.setDeleted(true);

	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
