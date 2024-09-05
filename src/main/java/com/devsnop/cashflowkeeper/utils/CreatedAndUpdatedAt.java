package com.devsnop.cashflowkeeper.utils;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CreatedAndUpdatedAt {

	protected Calendar createdAt;

	protected Calendar updatedAt;

	@PrePersist
	protected void onCreate() {

		if (createdAt == null)
			createdAt = Calendar.getInstance();

		updatedAt = Calendar.getInstance();
	}

	@PreUpdate
	protected void onUpdate() {

		updatedAt = Calendar.getInstance();

		if (createdAt == null)
			createdAt = updatedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	public Calendar getCreatedAt() {

		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {

		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	public Calendar getUpdatedAt() {

		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {

		this.updatedAt = updatedAt;
	}

}
