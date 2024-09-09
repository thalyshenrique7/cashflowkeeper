package com.devsnop.cashflowkeeper.service.strategy;

import org.springframework.stereotype.Component;

import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.entity.Transaction;

@Component
public class CurrentAccount implements GenerateTransactionService {

	@Override
	public void createTransaction(Account originAccount, Account destinationAccount) {

		if (originAccount != null && destinationAccount != null) {

			Transaction transaction = new Transaction();
			transaction.setOriginAccountId(originAccount.getId());
			transaction.setDestinationAccountId(destinationAccount.getId());
			// transaction.setValueTransaction(originAccount.getBalance());
			transaction.setTransactionType(originAccount.getAccountType().getDescription());
		}

	}

}
