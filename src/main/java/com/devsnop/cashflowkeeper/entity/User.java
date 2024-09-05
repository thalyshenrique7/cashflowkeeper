package com.devsnop.cashflowkeeper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private boolean active = true;

	private boolean deleted = false;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
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

}
