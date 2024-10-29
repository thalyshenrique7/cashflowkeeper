package com.devsnop.cashflowkeeper.service.strategy;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Transaction;

public interface GenerateSavingsAccountTransactionService {

	Transaction createWithdrawTransaction(TransactionDTO transactionDTO);
}
