package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.repository.UserRepository;
import com.devsnop.cashflowkeeper.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(User user) {

		this.userRepository.save(user);
	}

}
