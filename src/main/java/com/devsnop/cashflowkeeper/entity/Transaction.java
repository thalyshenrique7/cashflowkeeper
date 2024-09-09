package com.devsnop.cashflowkeeper.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

/*
 * Created by Thalys Henrique at 09/09/24
 */
@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

	private Long originAccountId;

	private Long destinationAccountId;

	private BigDecimal valueTransaction;

	private String transactionType;

	public Long getOriginAccountId() {
		return originAccountId;
	}

	public void setOriginAccountId(Long originAccountId) {
		this.originAccountId = originAccountId;
	}

	public Long getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(Long destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public BigDecimal getValueTransaction() {
		return valueTransaction;
	}

	public void setValueTransaction(BigDecimal valueTransaction) {
		this.valueTransaction = valueTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
