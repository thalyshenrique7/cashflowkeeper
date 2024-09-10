package com.devsnop.cashflowkeeper.dto.category;

import com.devsnop.cashflowkeeper.enums.CategoryType;
import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;

public class CategoryDTO extends AbstractDTO {

	private String name;

	private CategoryType categoryType;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

}
