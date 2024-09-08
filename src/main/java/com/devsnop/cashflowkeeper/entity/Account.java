package com.devsnop.cashflowkeeper.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
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

	private BigDecimal balance = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	public AccountType getAccountType() {

		return accountType;
	}

	public void setAccountType(AccountType accountType) {

		this.accountType = accountType;
	}

	public BigDecimal getBalance() {

		return balance;
	}

	public void setBalance(BigDecimal balance) {

		this.balance = balance;
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

}
