package com.devsnop.cashflowkeeper.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.devsnop.cashflowkeeper.dto.user.UserDTO;
import com.devsnop.cashflowkeeper.dto.user.UserDTODetails;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.service.impl.UserAbstractServiceMapper;

public interface UserService extends UserAbstractServiceMapper<User, UserDTO> {

	void validateCpf(String cpf);

	UserDTODetails findUserById(Long id) throws NotFoundException;
}
