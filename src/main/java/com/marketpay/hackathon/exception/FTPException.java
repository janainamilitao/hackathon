package com.marketpay.hackathon.exception;

public class FTPException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FTPException(String mensagem) {
		super(mensagem);
	}

}
