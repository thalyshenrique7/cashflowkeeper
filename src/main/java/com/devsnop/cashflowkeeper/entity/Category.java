package com.devsnop.cashflowkeeper.entity;

import com.devsnop.cashflowkeeper.enums.CategoryType;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

	private String name;

	@Enumerated(EnumType.STRING)
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
