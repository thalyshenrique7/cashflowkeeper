package com.devsnop.cashflowkeeper.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.enums.AccountType;
import com.devsnop.cashflowkeeper.utils.CreatedAndUpdatedAt;

@Entity
@Table(name = "account")
public class Account extends CreatedAndUpdatedAt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private BigDecimal balance;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

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

}
