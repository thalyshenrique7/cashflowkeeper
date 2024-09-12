package com.devsnop.cashflowkeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.service.TransactionService;

@RestController
@RequestMapping(value = "/api/transaction", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTransferTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
		this.transactionService.checkTransactionType(transactionDTO);
	}

}
