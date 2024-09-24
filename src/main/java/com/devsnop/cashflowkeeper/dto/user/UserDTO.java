package com.devsnop.cashflowkeeper.dto.user;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class UserDTO extends AbstractDTO {

	private String firstName;
	private String lastName;
	private String cpf;

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

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", cpf=" + cpf + ", getId()=" + getId()
				+ "]";
	}

}
