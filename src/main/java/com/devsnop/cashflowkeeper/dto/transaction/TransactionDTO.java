package com.devsnop.cashflowkeeper.dto.transaction;

import java.math.BigDecimal;

import com.devsnop.cashflowkeeper.enums.TransactionType;
import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class TransactionDTO extends AbstractDTO {

	private Long originAccountId;

	private Long destinationAccountId;

	private BigDecimal valueTransaction;

	private TransactionType transactionType;

	private BigDecimal valueTax;

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
