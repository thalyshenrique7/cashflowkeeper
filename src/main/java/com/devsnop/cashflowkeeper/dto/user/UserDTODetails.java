package com.devsnop.cashflowkeeper.dto.user;

import java.util.List;

import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;

public class UserDTODetails {

	private String username;
	private String cpf;

	private List<AccountDTODetails> accounts;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<AccountDTODetails> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTODetails> accounts) {
		this.accounts = accounts;
	}

}
