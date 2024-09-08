package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.user.UserDTO;
import com.devsnop.cashflowkeeper.dto.user.UserDTODetails;
import com.devsnop.cashflowkeeper.entity.User;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper extends AbstractMapperImpl<User> implements AbstractMapper<User, UserDTO> {

	public UserMapper() {

		super(User.class);
	}

	public abstract UserDTODetails toDTODetails(User entity);

}
