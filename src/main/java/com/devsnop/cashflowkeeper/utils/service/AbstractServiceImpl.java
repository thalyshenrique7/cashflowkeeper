package com.devsnop.cashflowkeeper.utils.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Transactional
public abstract class AbstractServiceImpl<TEntity extends AbstractEntity> implements AbstractService<TEntity> {

	@Autowired
	private AbstractRepository<TEntity> abstractRepository;

	protected Class<TEntity> typeBase;

	public AbstractServiceImpl(Class<TEntity> typeBase) {

		this.typeBase = typeBase;
	}

	@Override
	public TEntity findById(Long id) throws NotFoundException {

		Assert.notNull(id, "id");

		TEntity entity = abstractRepository.findById(id).orElse(null);

		if (entity == null)
			throw new NotFoundException();

		return entity;
	}

	@Override
	public List<TEntity> findByIds(final Collection<Long> ids) {

		Assert.notEmpty(ids, "ids");

		Specification<TEntity> spec = new Specification<TEntity>() {

			@Override
			public Predicate toPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate predicate = root.get("id").in(ids);

				return predicate;
			}
		};

		List<TEntity> entity = abstractRepository.findAll(spec);

		return entity;
	}

	@Override
	public void remove(TEntity entity) throws Exception {

		validateBeforeRemove(entity);

		abstractRepository.delete(entity);
	}

	@Override
	public void remove(List<TEntity> entities) throws Exception {

		for (TEntity entity : entities) {
			validateBeforeRemove(entity);
			abstractRepository.delete(entity);
		}

	}

	@Override
	public TEntity save(TEntity entity) throws Exception {

		if (entity.getId() != null && entity.getId() > 0)
			validateBeforeUpdate(entity);
		else
			validateBeforeSave(entity);

		return abstractRepository.save(entity);
	}

	@Override
	public List<TEntity> save(List<TEntity> entities) throws Exception {

		List<TEntity> result = new ArrayList<TEntity>();

		if (entities == null)
			return result;

		for (TEntity entity : entities)
			result.add(save(entity));

		return result;
	}

	@Override
	public List<TEntity> findAll() {

		return abstractRepository.findAll();
	}

	@Override
	public Page<TEntity> findAll(Pageable pageable) {

		return abstractRepository.findAll(pageable);
	}

	@Override
	public TEntity findOne(Specification<TEntity> specification) {

		return abstractRepository.findOne(specification).orElse(null);
	}

	@Override
	public List<TEntity> findAll(Specification<TEntity> specification) {

		return abstractRepository.findAll(specification);
	}

	@Override
	public List<TEntity> findAll(Specification<TEntity> specification, Sort sort) {

		return abstractRepository.findAll(specification, sort);
	}

	@Override
	public Page<TEntity> findAll(Specification<TEntity> specification, Pageable pageable) {

		return abstractRepository.findAll(specification, pageable);
	}

	protected void validateBeforeSave(TEntity entity) throws Exception {

	}

	protected void validateBeforeUpdate(TEntity entity) throws Exception {

	}

	protected void validateBeforeRemove(TEntity entity) throws Exception {

	}

}
