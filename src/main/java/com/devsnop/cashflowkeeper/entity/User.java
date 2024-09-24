package com.devsnop.cashflowkeeper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private boolean active = true;

	private boolean deleted = false;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Account> accounts;

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

	public boolean isActive() {

		return active;
	}

	public void setActive(boolean active) {

		this.active = active;
	}

	public boolean isDeleted() {

		return deleted;
	}

	public void setDeleted(boolean deleted) {

		this.deleted = deleted;
	}

	public void delete() {

		this.setActive(false);
		this.setDeleted(true);
	}

	public List<Account> getAccounts() {

		if (accounts == null)
			accounts = new ArrayList<Account>();

		return accounts;
	}

	public void setAccounts(List<Account> accounts) {

		this.accounts = accounts;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
