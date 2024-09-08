package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.user.UserDTO;
import com.devsnop.cashflowkeeper.dto.user.UserDTODetails;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.mapper.UserMapper;
import com.devsnop.cashflowkeeper.service.UserService;
import com.devsnop.cashflowkeeper.utils.exception.AbstractException;
import com.devsnop.cashflowkeeper.utils.validation.CpfValidator;

@Service
public class UserServiceImpl extends UserAbstractServiceMapperImpl<User, UserDTO> implements UserService {

	public UserServiceImpl() {

		super(User.class);
	}

	@Autowired
	private UserMapper userMapper;

	@Override
	public void validateCpf(String cpf) {
		if (!CpfValidator.isCpfValid(cpf))
			throw new AbstractException("Cpf is not valid.");
	}

	@Override
	public UserDTODetails findUserById(Long id) throws NotFoundException {

		User user = super.findById(id);

		return this.userMapper.toDTODetails(user);
	}

}
