package com.devsnop.cashflowkeeper.service.strategy;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Transaction;

public interface GenerateCurrentAccountTransactionService {

	Transaction createTransferTransaction(TransactionDTO transactionDTO);

	Transaction createDepositTransaction(TransactionDTO transactionDTO);

	Transaction createWithdrawTransaction(TransactionDTO transactionDTO, boolean isCalculateTax);

}
