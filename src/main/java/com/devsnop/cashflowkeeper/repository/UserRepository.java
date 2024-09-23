package com.devsnop.cashflowkeeper.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.utils.repository.AbstractRepository;

@Repository
public interface UserRepository extends AbstractRepository<User> {

	@Query("SELECT u FROM User u WHERE u.cpf = :cpf AND u.active = 1 ")
	User findByCpf(@Param(value = "cpf") String cpf);
}
