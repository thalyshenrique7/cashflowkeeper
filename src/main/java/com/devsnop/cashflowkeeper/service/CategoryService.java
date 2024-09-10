package com.devsnop.cashflowkeeper.service;

import com.devsnop.cashflowkeeper.entity.Category;

public interface CategoryService {

	Category findCategoryById(Long categoryId);

	boolean validateExistingCategory(Long categoryId);
}
