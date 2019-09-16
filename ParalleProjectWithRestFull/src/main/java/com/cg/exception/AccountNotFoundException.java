package com.cg.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception{
	public AccountNotFoundException() {
		super();
	}

	public AccountNotFoundException(String msg) {
		super(msg);
	}
}
