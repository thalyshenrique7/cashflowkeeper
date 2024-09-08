package com.devsnop.cashflowkeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsnop.cashflowkeeper.dto.user.UserDTO;
import com.devsnop.cashflowkeeper.dto.user.UserDTODetails;
import com.devsnop.cashflowkeeper.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UserDTO userDTO) throws Exception {

		this.userService.save(userDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTODetails> findUserById(@PathVariable(value = "id") Long id) throws NotFoundException {

		return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK);
	}
}
