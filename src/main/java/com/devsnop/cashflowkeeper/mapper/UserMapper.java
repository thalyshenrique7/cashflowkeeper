package com.devsnop.cashflowkeeper.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.UserDTO;
import com.devsnop.cashflowkeeper.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper extends User implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	public UserMapper() {

		super(User.class);
	}

	public abstract UserDTO toDTO(User entity);

	public abstract User toEntity(UserDTO dto);

}
