package com.devsnop.cashflowkeeper.service.strategy;

import com.devsnop.cashflowkeeper.entity.Account;

public interface GenerateTransactionService {

	void createTransaction(Account originAccount, Account destinationAccount);

}
