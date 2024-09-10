package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.entity.Category;
import com.devsnop.cashflowkeeper.repository.CategoryRepository;
import com.devsnop.cashflowkeeper.service.CategoryService;
import com.devsnop.cashflowkeeper.utils.exception.AbstractException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category findCategoryById(Long categoryId) {
		return this.categoryRepository.findById(categoryId).orElseThrow(() -> new AbstractException(categoryId));
	}

	@Override
	public boolean validateExistingCategory(Long categoryId) {
		return this.findCategoryById(categoryId) != null;
	}
}
