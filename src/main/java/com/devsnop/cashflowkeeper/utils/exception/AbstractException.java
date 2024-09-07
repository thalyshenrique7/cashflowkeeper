package com.devsnop.cashflowkeeper.utils.exception;

public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 985098201651404172L;

	public AbstractException(Object id) {
		super("ID " + id + " not found.");
	}

	public AbstractException(String message) {
		super(message);
	}
}
