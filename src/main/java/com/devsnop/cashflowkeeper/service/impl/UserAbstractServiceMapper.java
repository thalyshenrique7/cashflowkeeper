package com.devsnop.cashflowkeeper.service.impl;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractServiceMapper;

public interface UserAbstractServiceMapper<TEntity extends AbstractEntity, TDto extends AbstractDTO>
		extends AbstractServiceMapper<TEntity, TDto> {

}
