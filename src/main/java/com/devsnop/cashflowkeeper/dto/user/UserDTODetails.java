package com.devsnop.cashflowkeeper.dto.user;

import java.util.List;

import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;

public class UserDTODetails {

	private String firstName;
	private String lastName;
	private String cpf;

	private List<AccountDTODetails> accounts;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
