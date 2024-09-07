package com.devsnop.cashflowkeeper.utils.mapper;

import java.util.List;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

public interface AbstractMapper<TEntity extends AbstractEntity, TDto extends AbstractDTO> {

	public TDto toDTO(TEntity entity);

	public List<TDto> toDTOs(List<TEntity> entities);

	public TEntity toEntity(TDto dto);

	public List<TEntity> toEntities(List<TDto> dtos);
}
