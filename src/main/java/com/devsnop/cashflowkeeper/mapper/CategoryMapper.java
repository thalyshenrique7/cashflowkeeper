package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.category.CategoryDTO;
import com.devsnop.cashflowkeeper.entity.Category;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CategoryMapper extends AbstractMapperImpl<Category>
		implements AbstractMapper<Category, CategoryDTO> {

	public CategoryMapper() {

		super(Category.class);
	}

}
