package com.devsnop.cashflowkeeper.test.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {

	@Autowired
	private UserRepository userRepository;

	private User user;

	@BeforeEach
	public void setUp() {

		user = this.createUserObject();
	}

	@DisplayName(value = "given user object when save then return saved user")
	@Test
	void testGivenUserObjectWhenSaveThenReturnSavedUser() {

		user = this.userRepository.save(user);

		assertNotNull(user);
		assertTrue(user.getId() > 0);
	}

	@DisplayName(value = "given user object when find by id then return user")
	@Test
	void testGivenUserObjectWhenFindByIdThenReturnUser() {

		this.userRepository.save(user);

		User savedUser = this.userRepository.findById(user.getId()).get();

		assertNotNull(user);
		assertEquals(savedUser.getId(), user.getId());
	}

	@DisplayName(value = "given user object when find by cpf then return user")
	@Test
	void testGivenUserObjectWhenFindByCpfThenReturnUser() {

		this.userRepository.save(user);

		User savedUser = this.userRepository.findByCpf(user.getCpf());

		assertNotNull(user);
		assertEquals(savedUser.getId(), user.getId());
	}

	@DisplayName(value = "given user object when delete then remove user")
	@Test
	void testGivenUserObjectWhenDeleteThenRemoveUser() {

		this.userRepository.save(user);

		this.userRepository.deleteById(user.getId());

		Optional<User> userOptional = this.userRepository.findById(user.getId());

		assertTrue(userOptional.isEmpty());
	}

	@DisplayName(value = "given user object when find by jpql then return user")
	@Test
	void testGivenUserObjectWhenFindByJPQLThenReturnUser() {

		this.userRepository.save(user);

		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		User savedUser = this.userRepository.findByJPQL(firstName, lastName);

		assertNotNull(savedUser);
		assertEquals(firstName, savedUser.getFirstName());
		assertEquals(lastName, savedUser.getLastName());
	}

	@DisplayName(value = "given user object when find by jpql named parameters then return user")
	@Test
	void testGivenUserObjectWhenFindByJPQLNamedParametersThenReturnUser() {

		this.userRepository.save(user);

		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		User savedUser = this.userRepository.findByJPQLNamedParameters(firstName, lastName);

		assertNotNull(savedUser);
		assertEquals(firstName, savedUser.getFirstName());
		assertEquals(lastName, savedUser.getLastName());
	}

	@DisplayName(value = "given user object when find by native sql then return user")
	@Test
	void testGivenUserObjectWhenFindByNativeSQLThenReturnUser() {

		this.userRepository.save(user);

		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		User savedUser = this.userRepository.findByNativeSQL(firstName, lastName);

		assertNotNull(savedUser);
		assertEquals(firstName, savedUser.getFirstName());
		assertEquals(lastName, savedUser.getLastName());
	}

	@DisplayName(value = "given user object when find by native sql with named parameters then return user")
	@Test
	void testGivenUserObjectWhenFindByNativeSQLWithNamedParametersThenReturnUser() {

		this.userRepository.save(user);

		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		User savedUser = this.userRepository.findByNativeSQLWithNamedParameters(firstName, lastName);

		assertNotNull(savedUser);
		assertEquals(firstName, savedUser.getFirstName());
		assertEquals(lastName, savedUser.getLastName());
	}

	private User createUserObject() {

		User user = new User();
		user.setId(1L);
		user.setFirstName("Javax");
		user.setLastName("Persistence");
		user.setCpf("95113463000");

		return user;
	}

}
