package com.devsnop.cashflowkeeper.utils.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsnop.cashflowkeeper.utils.exception.AbstractException;

public abstract class AbstractServiceImpl<T, ID> implements AbstractService<T, ID> {

	private JpaRepository<T, ID> jpaRepository;

	@Override
	public void save(T entity) {

		this.jpaRepository.save(entity);
	}

	@Override
	public void delete(ID id) {

		T entity = this.jpaRepository.findById(id).orElseThrow(() -> new AbstractException(id));

		this.jpaRepository.delete(entity);
	}

	@Override
	public T findById(ID id) {

		return this.findById(id);
	}

	@Override
	public List<T> findAll() {

		return this.jpaRepository.findAll();
	}

}
