package com.devsnop.cashflowkeeper.service;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;

public interface TransactionService {

	void createTransferTransaction(TransactionDTO transactionDTO) throws Exception;

	void createDepositTransaction(TransactionDTO transactionDTO) throws Exception;

	void createWithdrawTransaction(TransactionDTO transactionDTO) throws Exception;
}
