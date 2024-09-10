package com.devsnop.cashflowkeeper.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.entity.Account;

public interface AccountService {

	void create(AccountDTO accountDTO) throws NotFoundException;

	AccountDTODetails findAccountDetailsById(Long accountDetailsId);

	Account findAccountById(Long accountId);
}
