package com.devsnop.cashflowkeeper.utils.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AbstractService<T, ID> {

	void save(T entity);

	void delete(ID id);

	T findById(ID id);

	List<T> findAll();
}
