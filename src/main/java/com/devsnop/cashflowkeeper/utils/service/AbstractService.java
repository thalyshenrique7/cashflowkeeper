package com.devsnop.cashflowkeeper.utils.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface AbstractService<TEntity> {

	TEntity findById(Long id) throws NotFoundException;

	List<TEntity> findByIds(final Collection<Long> ids);

	TEntity save(TEntity entity) throws Exception;

	List<TEntity> save(List<TEntity> entities) throws Exception;

	List<TEntity> findAll();

	TEntity findOne(Specification<TEntity> specification);

	Page<TEntity> findAll(Pageable pageable);

	List<TEntity> findAll(Specification<TEntity> specification);

	List<TEntity> findAll(Specification<TEntity> specification, Sort sort);

	Page<TEntity> findAll(Specification<TEntity> specification, Pageable pageable);

	void remove(TEntity entity) throws Exception;

	void remove(List<TEntity> entities) throws Exception;
}
