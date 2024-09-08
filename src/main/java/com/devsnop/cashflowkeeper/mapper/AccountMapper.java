package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.account.AccountDTO;
import com.devsnop.cashflowkeeper.dto.account.AccountDTODetails;
import com.devsnop.cashflowkeeper.entity.Account;
import com.devsnop.cashflowkeeper.enums.AccountType;
import com.devsnop.cashflowkeeper.enums.CategoryType;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AccountMapper extends AbstractMapperImpl<Account> implements AbstractMapper<Account, AccountDTO> {

	public AccountMapper() {

		super(Account.class);
	}
	
	@Mappings({
		@Mapping(target = "accountType", source = "accountTypeId", qualifiedByName = "mapToAccountType"),
		@Mapping(target = "user.id", source = "userId"),
		@Mapping(target = "category.categoryType", source = "categoryId", qualifiedByName = "mapToCategoryType"),
	})
	public abstract Account toEntity(AccountDTO dto);

	@Mappings({
		@Mapping(target = "accountTypeDescription", source = "accountType.description"),
		@Mapping(target = "categoryDescription", source = "category.categoryType.description"),
	})
	public abstract AccountDTODetails toDTODetails(Account entity);
	
	@Named("mapToAccountType")
	protected AccountType mapToAccountType(Long accountTypeId) {
		return AccountType.getAccountTypeById(accountTypeId);
	}
	
	@Named("mapToCategoryType")
	protected CategoryType mapToCategoryType(Long categoryTypeId) {
		return CategoryType.getCategoryTypeById(categoryTypeId);
	}

}
