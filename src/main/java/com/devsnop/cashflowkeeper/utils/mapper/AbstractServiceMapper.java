package com.devsnop.cashflowkeeper.utils.mapper;

import com.devsnop.cashflowkeeper.utils.dto.AbstractDTO;
import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;
import com.devsnop.cashflowkeeper.utils.service.AbstractService;

public interface AbstractServiceMapper<TEntity extends AbstractEntity, TDto extends AbstractDTO>
		extends AbstractService<TEntity> {

}
