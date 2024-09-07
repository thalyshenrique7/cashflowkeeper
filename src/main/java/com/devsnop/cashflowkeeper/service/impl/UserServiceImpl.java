package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.stereotype.Component;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.service.UserService;
import com.devsnop.cashflowkeeper.utils.exception.AbstractException;
import com.devsnop.cashflowkeeper.utils.service.AbstractServiceImpl;
import com.devsnop.cashflowkeeper.utils.validation.CpfValidator;

@Component
public class UserServiceImpl extends AbstractServiceImpl<User, Long> implements UserService {

	@Override
	public void validateCpf(String cpf) {
		if (!CpfValidator.isCpfValid(cpf))
			throw new AbstractException("Cpf is not valid.");
	}

	@Override
	public void save(User user) {
		
		this.validateCpf(user.getCpf());
		
		super.save(user);
	}

}
