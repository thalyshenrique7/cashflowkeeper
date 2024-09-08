package com.devsnop.cashflowkeeper.enums;

public enum CategoryType {

	REVENUE(1L, "Revenue"), EXPENSE(2L, "Expense");

	CategoryType(Long id, String description) {

		this.id = id;
		this.description = description;
	}

	private Long id;

	private String description;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public static CategoryType getCategoryTypeById(Long categoryTypeId) {

		for (CategoryType type : CategoryType.values())
			if (type.getId().equals(categoryTypeId))
				return type;

		return null;
	}
}
