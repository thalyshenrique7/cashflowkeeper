package com.devsnop.cashflowkeeper.repository;

import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Repository
public interface TransactionRepository extends AbstractRepository<Transaction> {

}
