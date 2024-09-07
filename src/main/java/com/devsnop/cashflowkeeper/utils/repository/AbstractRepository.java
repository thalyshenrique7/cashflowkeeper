package com.devsnop.cashflowkeeper.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractRepository<TEntity> extends JpaRepository<TEntity, Long>, JpaSpecificationExecutor<TEntity> {

}
