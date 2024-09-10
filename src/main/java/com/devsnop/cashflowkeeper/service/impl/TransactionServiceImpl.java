package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.exception.AccountException;
import com.devsnop.cashflowkeeper.repository.TransactionRepository;
import com.devsnop.cashflowkeeper.service.AccountService;
import com.devsnop.cashflowkeeper.service.TransactionService;
import com.devsnop.cashflowkeeper.service.strategy.CurrentAccount;
import com.devsnop.cashflowkeeper.service.strategy.SavingsAccount;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CurrentAccount currentAccount;

	@Autowired
	private SavingsAccount savingsAccount;

	@Autowired
	private AccountService accountService;

	@Override
	public void createTransferTransaction(TransactionDTO transactionDTO) throws Exception {

		Account originAccount = this.accountService.findAccountById(transactionDTO.getOriginAccountId());

		Transaction transaction = null;

		switch (originAccount.getAccountType()) {

		case CURRENT:

			transaction = this.currentAccount.createTransferTransaction(transactionDTO);
			break;
		case SAVINGS:

			transaction = this.savingsAccount.createTransferTransaction(transactionDTO);
			break;
		}

		try {

			this.transactionRepository.save(transaction);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the transaction.", e);
		}

	}

	@Override
	public void createDepositTransaction(TransactionDTO transactionDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void createWithdrawTransaction(TransactionDTO transactionDTO) throws Exception {
		// TODO Auto-generated method stub

	}

}
