package com.devsnop.cashflowkeeper.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.mapper.TransactionMapper;

@Component
public class CurrentAccount implements GenerateTransactionService {

	@Autowired
	private TransactionMapper transactionMapper;

	@Override
	public Transaction createTransferTransaction(TransactionDTO transactionDTO) {

		Transaction transaction = null;

		if (transactionDTO != null)
			transaction = this.transactionMapper.toEntity(transactionDTO);

		return transaction;
	}

	@Override
	public Transaction createDepositTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction createWithdrawTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
