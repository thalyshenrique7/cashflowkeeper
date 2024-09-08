package com.devsnop.cashflowkeeper.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;

public interface AccountService {

	void create(AccountDTO accountDTO) throws NotFoundException;

	AccountDTODetails findAccountById(Long accountId);
}
