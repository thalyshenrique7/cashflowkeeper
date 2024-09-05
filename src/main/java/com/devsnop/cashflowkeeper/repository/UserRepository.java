package com.devsnop.cashflowkeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
