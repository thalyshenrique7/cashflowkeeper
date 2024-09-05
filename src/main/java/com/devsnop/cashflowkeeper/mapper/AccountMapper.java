package com.devsnop.cashflowkeeper.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.AccountDTO;
import com.devsnop.cashflowkeeper.entity.Account;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AccountMapper extends Account implements Serializable {

	private static final long serialVersionUID = 985098201651404172L;

	public AccountMapper() {

		super(Account.class);
	}

	public abstract AccountDTO toDTO(Account entity);

	public abstract Account toEntity(AccountDTO dto);

}
