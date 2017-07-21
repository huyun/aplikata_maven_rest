package com.aplikata.exception;

public class DaoException extends BaseException {

	public DaoException(String code) {
		super(code);
	}

	public DaoException(String code, Object[] values) {
		super(code, values);
	}

	private static final long serialVersionUID = -3711290613973933714L;

}
