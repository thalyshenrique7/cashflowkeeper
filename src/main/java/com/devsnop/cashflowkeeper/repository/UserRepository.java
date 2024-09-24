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

	@Query("select u from User u where u.firstName =?1 and u.lastName =?2")
	User findByJPQL(String firstName, String lastName);

	@Query("select u from User u where u.firstName =:firstName and u.lastName =:lastName")
	User findByJPQLNamedParameters(@Param("firstName") String firstName, @Param("lastName") String lastName);

	@Query(value = "SELECT * FROM users u WHERE u.first_name =?1 AND u.last_name =?2", nativeQuery = true)
	User findByNativeSQL(String firstName, String lastName);

	@Query(value = "SELECT * FROM users u WHERE u.first_name =:firstName AND u.last_name =:lastName", nativeQuery = true)
	User findByNativeSQLWithNamedParameters(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
