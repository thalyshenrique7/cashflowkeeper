package com.devsnop.cashflowkeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody User user) {

		this.userService.create(user);
	}
}
