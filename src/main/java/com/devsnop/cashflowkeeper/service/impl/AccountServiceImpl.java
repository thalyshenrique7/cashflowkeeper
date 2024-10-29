package com.devsnop.cashflowkeeper.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.exception.AccountException;
import com.devsnop.cashflowkeeper.mapper.AccountMapper;
import com.devsnop.cashflowkeeper.repository.AccountRepository;
import com.devsnop.cashflowkeeper.service.AccountService;
import com.devsnop.cashflowkeeper.service.CategoryService;
import com.devsnop.cashflowkeeper.service.UserService;
import com.devsnop.cashflowkeeper.utils.BigDecimalUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void create(AccountDTO accountDTO) throws NotFoundException {

		if (!this.hasUser(accountDTO.getUserId()))
			throw new AccountException("Account cannot be created because user don't exists.");

		if (this.isInitialBalanceLessOrEqualThanZero(accountDTO.getInitialBalance()))
			throw new AccountException("The initial balance must be greater than zero.");

		if (!this.categoryService.validateExistingCategory(accountDTO.getCategoryId()))
			throw new AccountException("Category must be register to created account.");

		Account account = this.accountMapper.toEntity(accountDTO);

		try {

			this.accountRepository.save(account);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the account.", e);
		}

	}

	private boolean isInitialBalanceLessOrEqualThanZero(BigDecimal initialBalance) {
		return BigDecimalUtils.isLessOrEqualThan(initialBalance, BigDecimal.ZERO);
	}

	private boolean hasUser(Long userId) throws NotFoundException {

		User user = this.userService.findById(userId);

		return user != null && user.isActive();
	}

	@Override
	public AccountDTODetails findAccountDetailsById(Long accountDetailsId) {

		Account account = this.accountRepository.findById(accountDetailsId)
				.orElseThrow(() -> new AccountException(accountDetailsId));

		if (account.isDeleted())
			throw new AccountException("Account does not exist or deleted.");

		AccountDTODetails dto = this.accountMapper.toDTODetails(account);

		return dto;
	}

	@Override
	public Account findAccountById(Long accountId) {
		return this.accountRepository.findById(accountId).orElseThrow(() -> new AccountException(accountId));
	}

	@Override
	public BigDecimal subtractValueFromAccount(Account account, BigDecimal valueTransaction, BigDecimal valueTax) {

		BigDecimal currentBalanceAccount = account.getBalance();

		BigDecimal balanceAfterSubtract = currentBalanceAccount.subtract(valueTransaction.add(valueTax));

		if (BigDecimalUtils.isLessThanZero(balanceAfterSubtract))
			throw new AccountException("Balance insufficient to realize transaction.");

		return balanceAfterSubtract;
	}

	@Override
	public BigDecimal addDepositValueToAccount(Account account, BigDecimal valueTransaction) {

		BigDecimal currentBalanceAccount = account.getBalance();

		BigDecimal balanceAfterAdd = currentBalanceAccount.add(valueTransaction);

		return balanceAfterAdd;
	}

}
