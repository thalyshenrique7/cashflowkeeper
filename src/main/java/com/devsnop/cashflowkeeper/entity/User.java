package com.devsnop.cashflowkeeper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.utils.AbstractEntity;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

	private String username;

	private boolean active = true;

	private boolean deleted = false;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Account> accounts;

	public User(Class<User> class1) {

	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
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

}
