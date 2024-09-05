package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.AccountDTO;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.mapper.AccountMapper;
import com.devsnop.cashflowkeeper.repository.AccountRepository;
import com.devsnop.cashflowkeeper.service.AccountService;
import com.devsnop.cashflowkeeper.utils.BigDecimalUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public void create(AccountDTO accountDTO) {

		Account account = this.accountMapper.toEntity(accountDTO);

		this.validateAccount(accountDTO);

		try {

			this.accountRepository.save(account);

		} catch (Exception e) {

		}

	}

	private boolean validateAccount(AccountDTO accountDTO) {

		return BigDecimalUtils.isGreaterOrEqualThanZero(accountDTO.getBalance());
	}

}
