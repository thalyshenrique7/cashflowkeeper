package com.devsnop.cashflowkeeper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.devsnop.cashflowkeeper.dto.transaction.TransactionDTO;
import com.devsnop.cashflowkeeper.entity.Transaction;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapper;
import com.devsnop.cashflowkeeper.utils.mapper.AbstractMapperImpl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class TransactionMapper extends AbstractMapperImpl<Transaction>
		implements AbstractMapper<Transaction, TransactionDTO> {

	public TransactionMapper() {

		super(Transaction.class);
	}

	@Mappings({
		@Mapping(target = "originAccount.id", source = "originAccountId"),
		@Mapping(target = "destinationAccount.id", source = "destinationAccountId"),
	})
	public abstract Transaction toEntity(TransactionDTO dto);
}
