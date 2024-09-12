package com.devsnop.cashflowkeeper.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.mapper.TransactionMapper;

@Component
public class SavingsAccount implements GenerateSavingsAccountTransactionService {

	@Autowired
	private TransactionMapper transactionMapper;

	@Override
	public Transaction createDepositTransaction(TransactionDTO transactionDTO) {

		Transaction transaction = this.transactionMapper.toEntity(transactionDTO);

		return transaction;
	}

	@Override
	public Transaction createWithdrawTransaction(TransactionDTO transactionDTO) {

		Transaction transaction = this.transactionMapper.toEntity(transactionDTO);

		return transaction;
	}

}
