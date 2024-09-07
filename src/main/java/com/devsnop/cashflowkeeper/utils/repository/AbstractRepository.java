package com.devsnop.cashflowkeeper.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.utils.entity.AbstractEntity;

@Repository
public interface AbstractRepository<TEntity extends AbstractEntity>
		extends JpaRepository<TEntity, Long>, JpaSpecificationExecutor<TEntity> {

}
