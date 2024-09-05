package com.devsnop.cashflowkeeper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsnop.cashflowkeeper.dto.UserDTO;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.mapper.UserMapper;
import com.devsnop.cashflowkeeper.repository.UserRepository;
import com.devsnop.cashflowkeeper.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public void create(UserDTO userDTO) {

		User user = this.userMapper.toEntity(userDTO);

		this.userRepository.save(user);
	}

}
