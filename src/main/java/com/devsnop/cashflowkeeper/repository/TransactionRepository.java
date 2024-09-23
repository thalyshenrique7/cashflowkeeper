package com.devsnop.cashflowkeeper.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Repository
public interface TransactionRepository extends AbstractRepository<Transaction> {

	List<Transaction> findByOriginAccountUserIdAndCreatedAtBetween(Long userId, Calendar startDate, Calendar endDate);
}
