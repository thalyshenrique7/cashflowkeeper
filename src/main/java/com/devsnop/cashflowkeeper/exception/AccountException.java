package com.devsnop.cashflowkeeper.exception;

public class AccountException extends RuntimeException {

	private static final long serialVersionUID = 985098201651404172L;

	public AccountException(String message) {

		super(message);
	}

	public AccountException(Long id) {

		super("User ID " + id + " not found.");
	}
}
