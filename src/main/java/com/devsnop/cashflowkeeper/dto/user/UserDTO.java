package com.devsnop.cashflowkeeper.dto.user;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class UserDTO extends AbstractDTO {

	private String username;
	private String cpf;

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

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", cpf=" + cpf + ", getId()=" + getId() + "]";
	}

}
