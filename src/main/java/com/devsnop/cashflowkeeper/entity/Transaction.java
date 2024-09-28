package com.devsnop.cashflowkeeper.entity;

import java.math.BigDecimal;

import com.devsnop.cashflowkeeper.enums.TransactionType;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * Created by Thalys Henrique at 09/09/24
 */
@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "origin_account_id", referencedColumnName = "id")
	private Account originAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destination_account_id", referencedColumnName = "id")
	private Account destinationAccount;

	@Column(name = "value_transaction", precision = 19, scale = 4)
	private BigDecimal valueTransaction;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Column(name = "value_tax", precision = 19, scale = 4)
	private BigDecimal valueTax;

	public Account getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public BigDecimal getValueTransaction() {
		return valueTransaction;
	}

	public void setValueTransaction(BigDecimal valueTransaction) {
		this.valueTransaction = valueTransaction;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getValueTax() {
		return valueTax;
	}

	public void setValueTax(BigDecimal valueTax) {
		this.valueTax = valueTax;
	}

}
