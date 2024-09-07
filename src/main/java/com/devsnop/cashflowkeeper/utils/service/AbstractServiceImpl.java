package com.devsnop.cashflowkeeper.utils.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.exception.AbstractException;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Transactional
public abstract class AbstractServiceImpl<TEntity extends AbstractEntity> implements AbstractService<TEntity> {

	@Autowired
	private AbstractRepository<TEntity> jpaRepository;

	private Class<TEntity> typeBase;

	public AbstractServiceImpl(Class<TEntity> typeBase) {

		this.typeBase = typeBase;
	}

	@Override
	public void save(TEntity entity) {

		this.jpaRepository.save(entity);
	}

	@Override
	public void delete(Long id) {

		TEntity entity = this.jpaRepository.findById(id).orElseThrow(() -> new AbstractException(id));

		this.jpaRepository.delete(entity);
	}

	@Override
	public TEntity findById(Long id) {

		return this.findById(id);
	}

	@Override
	public List<TEntity> findAll() {

		return this.jpaRepository.findAll();
	}

}
