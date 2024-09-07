package com.devsnop.cashflowkeeper.utils.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	protected Calendar createdAt;

	@Column
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
