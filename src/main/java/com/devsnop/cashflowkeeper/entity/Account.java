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
import com.devsnop.cashflowkeeper.utils.AbstractEntity;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private BigDecimal balance = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Account(Class<Account> class1) {

	}

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
