package com.devsnop.cashflowkeeper.utils.mapper;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.service.AbstractService;

public interface AbstractServiceMapper<TEntity extends AbstractEntity, TDto extends AbstractDTO>
		extends AbstractService<TEntity> {

	TDto toDTO(TEntity entity);

	List<TDto> toDTOs(List<TEntity> entities);

	TEntity toEntity(TDto dto);

	List<TEntity> toEntities(List<TDto> dtos);

	TDto findDtoById(Long id);

	List<TDto> findDtoByIds(final Collection<Long> ids);

	List<TDto> findAllDto();

	TDto findOneDto(Specification<TEntity> specification);

	Page<TDto> findAllDto(Pageable pageable);

	List<TDto> findAllDto(Specification<TEntity> specification);

	List<TDto> findAllDto(Specification<TEntity> specification, Sort sort);

	Page<TDto> findAllDto(Specification<TEntity> specification, Pageable pageable);

	List<TEntity> saveDtos(List<TDto> dto) throws Exception;

	TEntity save(TDto dto) throws Exception;

	Page<TDto> toPageDTO(Page<TEntity> page, Pageable pageable);
}
