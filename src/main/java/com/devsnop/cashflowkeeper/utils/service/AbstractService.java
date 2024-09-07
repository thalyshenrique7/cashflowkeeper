package com.devsnop.cashflowkeeper.utils.service;

import java.util.List;

public interface AbstractService<TEntity> {

	void save(TEntity entity);

	void delete(Long id);

	TEntity findById(Long id);

	List<TEntity> findAll();
}
