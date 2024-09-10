package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = CategoryMapper.class)
public abstract class AccountMapper extends AbstractMapperImpl<Account> implements AbstractMapper<Account, AccountDTO> {

	public AccountMapper() {

		super(Account.class);
	}
	
	@Mappings({
		@Mapping(target = "user.id", source = "userId"),
		@Mapping(target = "balance", source = "initialBalance"),
		@Mapping(target = "category.id", source = "categoryId"),
	})
	public abstract Account toEntity(AccountDTO dto);

	@Mappings({
		@Mapping(target = "accountTypeDescription", source = "accountType.description"),
		@Mapping(target = "categoryTypeDescription", source = "category.categoryType.description"),
		@Mapping(target = "categoryName", source = "category.name"),
	})
	public abstract AccountDTODetails toDTODetails(Account entity);

}
