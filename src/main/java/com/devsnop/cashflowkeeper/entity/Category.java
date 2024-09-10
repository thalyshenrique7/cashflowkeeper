package com.devsnop.cashflowkeeper.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.devsnop.cashflowkeeper.enums.CategoryType;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

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
