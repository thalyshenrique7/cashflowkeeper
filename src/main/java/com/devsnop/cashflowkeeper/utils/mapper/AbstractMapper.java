package com.devsnop.cashflowkeeper.utils.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

public interface AbstractMapper<TEntity extends AbstractEntity, TDto extends AbstractDTO> {

	public TDto toDTO(TEntity entity);

	public List<TDto> toDTOs(List<TEntity> entities);

	public TEntity toEntity(TDto dto);

	public List<TEntity> toEntity(List<TDto> dto);

	default Page<TDto> toPageDTO(Page<TEntity> page, Pageable pageable) {

		Assert.notNull(page, "Page cannot be null.");
		Assert.notNull(pageable, "Pageable cannot be null.");

		Page<TDto> pageDto = new PageImpl<TDto>(toDTOs(page.getContent()), pageable, page.getTotalElements());
		return pageDto;

	}
}
