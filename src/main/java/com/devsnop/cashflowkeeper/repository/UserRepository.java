package com.devsnop.cashflowkeeper.repository;

import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Repository
public interface UserRepository extends AbstractRepository<User> {

}
