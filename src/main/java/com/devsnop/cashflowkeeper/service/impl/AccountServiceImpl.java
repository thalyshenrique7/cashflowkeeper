package com.devsnop.cashflowkeeper.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.exception.AccountException;
import com.devsnop.cashflowkeeper.mapper.AccountMapper;
import com.devsnop.cashflowkeeper.repository.AccountRepository;
import com.devsnop.cashflowkeeper.service.AccountService;
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

	@Override
	public void create(AccountDTO accountDTO) throws NotFoundException {

		Account account = this.accountMapper.toEntity(accountDTO);

		if (!this.hasUser(accountDTO.getUserId()))
			throw new AccountException("Account cannot be created because user don't exists.");

		if (!this.isInitialBalanceGreaterThanZero(accountDTO.getBalance()))
			throw new AccountException("The initial balance must be greater than zero.");

		try {

			this.accountRepository.save(account);

		} catch (Exception e) {
			throw new AccountException("Occurred an error to created the account.");
		}

	}

	private boolean isInitialBalanceGreaterThanZero(BigDecimal initialBalance) {
		return BigDecimalUtils.isGreaterOrEqualThanZero(initialBalance);
	}

	private boolean hasUser(Long userId) throws NotFoundException {
		return this.userService.findById(userId) != null;
	}

	@Override
	public AccountDTODetails findAccountById(Long accountId) {

		Account account = this.accountRepository.findById(accountId).orElseThrow(() -> new AccountException(accountId));
		
		AccountDTODetails dto = this.accountMapper.toDTODetails(account);

		return dto;
	}

}
