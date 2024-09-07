package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.AccountDTO;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AccountMapper extends AbstractMapperImpl<Account> implements AbstractMapper<Account, AccountDTO> {

	public AccountMapper() {

		super(Account.class);
	}

	public abstract AccountDTO toDTO(Account entity);

	public abstract Account toEntity(AccountDTO dto);

}
