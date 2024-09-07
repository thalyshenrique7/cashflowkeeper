package com.devsnop.cashflowkeeper.utils.mapper;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;
import com.devsnop.cashflowkeeper.utils.service.AbstractServiceImpl;

@Transactional
public class AbstractServiceMapperImpl<TEntity extends AbstractEntity, TDto extends AbstractDTO>
		extends AbstractServiceImpl<TEntity> implements AbstractServiceMapper<TEntity, TDto> {

	@Autowired
	private AbstractRepository<TEntity> abstractRepository;

	public AbstractServiceMapperImpl(Class<TEntity> typeBase) {

		super(typeBase);
	}

	@Override
	public void save(TEntity entity) {

		this.abstractRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
