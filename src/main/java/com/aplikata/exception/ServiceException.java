package com.aplikata.exception;


public class ServiceException extends BaseException {

	public ServiceException(String code) {
		super(code);
	}

	public ServiceException(String code, Object[] values) {
		super(code, values);
	}

	private static final long serialVersionUID = -3711290613973933714L;

}
