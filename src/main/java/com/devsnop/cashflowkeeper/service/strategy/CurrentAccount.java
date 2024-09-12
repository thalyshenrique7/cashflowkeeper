package com.devsnop.cashflowkeeper.service.strategy;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.mapper.TransactionMapper;
import com.devsnop.cashflowkeeper.service.AccountService;

@Component
public class CurrentAccount implements GenerateCurrentAccountTransactionService {

	private static final BigDecimal TAX_TWO_PERCENT = new BigDecimal("2.00");
	private static final BigDecimal VALUE_HUNDRED = new BigDecimal("100.00");

	private static final int QUANTITY_FREE_TRANSACTION = 3;

	@Autowired
	private TransactionMapper transactionMapper;

	@Autowired
	private AccountService accountService;

	@Override
	public Transaction createTransferTransaction(TransactionDTO transactionDTO) {

		Transaction transaction = this.transactionMapper.toEntity(transactionDTO);

		return transaction;
	}

	@Override
	public Transaction createDepositTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction createWithdrawTransaction(TransactionDTO transactionDTO) {

		Transaction transaction = null;
		BigDecimal valueToPayTax = null;

		Account account = this.accountService.findAccountById(transactionDTO.getOriginAccountId());

		if (account.getTransactionQuantity() > QUANTITY_FREE_TRANSACTION)
			valueToPayTax = this.calculateTax(transactionDTO.getValueTransaction());

		transactionDTO.setValueTax(valueToPayTax);

		return transaction;
	}

	private BigDecimal calculateTax(BigDecimal transactionValue) {

		BigDecimal valueToPay = transactionValue.multiply(TAX_TWO_PERCENT).divide(VALUE_HUNDRED);

		return valueToPay;
	}

}
