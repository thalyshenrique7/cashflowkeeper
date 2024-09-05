package com.devsnop.cashflowkeeper.dto;

import com.devsnop.cashflowkeeper.utils.AbstractDTO;

public class CategoryDTO extends AbstractDTO {

	private String name;

	private Long categoryTypeId;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Long getCategoryTypeId() {

		return categoryTypeId;
	}

	public void setCategoryTypeId(Long categoryTypeId) {

		this.categoryTypeId = categoryTypeId;
	}

}
