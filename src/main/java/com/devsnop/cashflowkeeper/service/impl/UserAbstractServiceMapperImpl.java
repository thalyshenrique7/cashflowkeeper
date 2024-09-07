package com.devsnop.cashflowkeeper.service.impl;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractServiceMapperImpl;

public abstract class UserAbstractServiceMapperImpl<TEntity extends AbstractEntity, TDto extends AbstractDTO>
		extends AbstractServiceMapperImpl<TEntity, TDto> implements UserAbstractServiceMapper<TEntity, TDto> {

	public UserAbstractServiceMapperImpl(Class<TEntity> typeBase) {

		super(typeBase);
	}

}
