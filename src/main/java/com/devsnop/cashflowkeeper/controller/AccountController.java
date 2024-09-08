package com.devsnop.cashflowkeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.service.AccountService;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody AccountDTO accountDTO) throws Exception {

		this.accountService.create(accountDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AccountDTODetails> findAccountById(@PathVariable(value = "id") Long id)
			throws NotFoundException {

		return new ResponseEntity<>(this.accountService.findAccountById(id), HttpStatus.OK);
	}

}
