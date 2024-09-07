package com.devsnop.cashflowkeeper.service;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.utils.service.AbstractService;

public interface UserService extends AbstractService<User, Long> {

	void validateCpf(String cpf);
}
