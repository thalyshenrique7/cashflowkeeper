package com.devsnop.cashflowkeeper.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.enums.AccountType;
import com.devsnop.cashflowkeeper.enums.TransactionType;
import com.devsnop.cashflowkeeper.exception.AccountException;
import com.devsnop.cashflowkeeper.mapper.TransactionMapper;
import com.devsnop.cashflowkeeper.repository.TransactionRepository;
import com.devsnop.cashflowkeeper.service.AccountService;
import com.devsnop.cashflowkeeper.service.TransactionService;
import com.devsnop.cashflowkeeper.service.strategy.CurrentAccount;
import com.devsnop.cashflowkeeper.service.strategy.SavingsAccount;
import com.devsnop.cashflowkeeper.utils.BigDecimalUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CurrentAccount currentAccount;

	@Autowired
	private SavingsAccount savingsAccount;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionMapper transactionMapper;

	@Override
	public void createTransferTransaction(TransactionDTO transactionDTO) throws Exception {

		this.validateAccountExists(transactionDTO);

		Account account = this.accountService.findAccountById(transactionDTO.getOriginAccountId());

		if (account.getAccountType().equals(AccountType.SAVINGS))
			throw new AccountException("This option don't available for savings accounts.");

		Transaction transaction = this.currentAccount.createTransferTransaction(transactionDTO);

		try {

			this.transactionRepository.save(transaction);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the transaction.", e);
		}

	}

	@Override
	public void createDepositTransaction(TransactionDTO transactionDTO) throws Exception {

		this.validateAccountExists(transactionDTO);

		if (BigDecimalUtils.isLessOrEqualThanZero(transactionDTO.getValueTransaction()))
			throw new TransactionException("Value transaction must be greater than zero.");

		Transaction transaction = this.transactionMapper.toEntity(transactionDTO);
		transaction.setDestinationAccount(null);

		Account account = this.accountService.findAccountById(transaction.getOriginAccount().getId());
		account.setBalance(this.accountService.addDepositValueToAccount(account, transaction.getValueTransaction()));

		try {

			this.transactionRepository.save(transaction);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the transaction.", e);
		}
	}

	@Override
	public void createWithdrawTransaction(TransactionDTO transactionDTO) throws Exception {

		this.validateAccountExists(transactionDTO);

		Long originAccountId = transactionDTO.getOriginAccountId();

		Account originAccount = this.accountService.findAccountById(originAccountId);

		this.validateBalanceAccount(originAccount, transactionDTO.getValueTransaction());

		boolean isCalculateTax = this.hasMadeThreeTransactionsInCurrentMonth(originAccountId);

		Transaction transaction = null;

		switch (originAccount.getAccountType()) {

		case CURRENT:
			transaction = this.currentAccount.createWithdrawTransaction(transactionDTO, isCalculateTax);
			break;
		case SAVINGS:
			transaction = this.savingsAccount.createWithdrawTransaction(transactionDTO);
			break;
		}

		transaction.setDestinationAccount(null);

		originAccount.setBalance(this.accountService.subtractValueFromAccount(originAccount,
				transaction.getValueTransaction(), transaction.getValueTax()));

		try {

			this.transactionRepository.save(transaction);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the transaction.", e);
		}
	}

	@Override
	public void checkTransactionType(TransactionDTO transactionDTO) throws Exception {

		switch (transactionDTO.getTransactionType()) {

		case TRANSFER:
			this.createTransferTransaction(transactionDTO);
			break;
		case DEPOSIT:
			this.createDepositTransaction(transactionDTO);
			break;
		case WITHDRAW:
			this.createWithdrawTransaction(transactionDTO);
			break;
		}

	}

	private boolean hasMadeThreeTransactionsInCurrentMonth(Long userId) {

		Calendar startOfMonth = Calendar.getInstance();
		startOfMonth.set(Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date().getTime())),
				Integer.parseInt((new SimpleDateFormat("MM")).format(new Date().getTime())),
				Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

		Calendar endOfMonth = Calendar.getInstance();
		endOfMonth.set(Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date().getTime())),
				Integer.parseInt((new SimpleDateFormat("MM")).format(new Date().getTime())),
				Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));

		List<Transaction> transactions = this.transactionRepository.findByOriginAccountUserIdAndCreatedAtBetween(userId,
				startOfMonth, endOfMonth);

		return transactions.size() > 3;
	}

	private void validateBalanceAccount(Account account, BigDecimal withdrawalValue) {

		if (BigDecimalUtils.isLessOrEqualThanZero(withdrawalValue))
			throw new TransactionException("Withdrawal value must be greather than zero.");

		if (BigDecimalUtils.isLessThan(account.getBalance(), withdrawalValue))
			throw new TransactionException("Balance value insufficient to make withdrawal. Your current balance is: "
					+ account.getBalance() + " .");
	}

	private void validateAccountExists(TransactionDTO transactionDTO) {

		Long originAccountId = transactionDTO.getOriginAccountId();

		Long destinationAccountId = transactionDTO.getDestinationAccountId();

		if (transactionDTO.getTransactionType().equals(TransactionType.TRANSFER)
				|| transactionDTO.getTransactionType().equals(TransactionType.WITHDRAW)) {

			if (originAccountId.equals(null) || (originAccountId.equals(null) && !destinationAccountId.equals(null))
					|| destinationAccountId.equals(null))
				throw new TransactionException(
						"You must informed an origin account and destination account to make transaction.");
		}

		if (transactionDTO.getTransactionType().equals(TransactionType.DEPOSIT)) {

			if (originAccountId.equals(null))
				throw new TransactionException("You must informed an origin account to make transaction.");
		}
	}

}
