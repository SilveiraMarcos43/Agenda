package com.totvs.compromisso.common.exception;

public class BusinessAlertException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessAlertException(String message) {
        super(message);
    }
}