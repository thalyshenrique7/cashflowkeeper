package com.devsnop.cashflowkeeper.service;

import com.devsnop.cashflowkeeper.dto.UserDTO;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.service.impl.UserAbstractServiceMapper;

public interface UserService extends UserAbstractServiceMapper<User, UserDTO> {

	void save(UserDTO userDTO);

	void validateCpf(String cpf);
}
