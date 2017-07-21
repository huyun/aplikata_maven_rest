package com.aplikata.exception;

/**
 * 异常基类，各个模块的运行期异常均继承与该类
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1381325479896057076L;

	private String code;
	private Object[] values;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}
	
	public BaseException(String code) {
		super();
		this.code = code;
	}

	public BaseException(String code, Object[] values) {
		super();
		this.code = code;
		this.values = values;
	}
}
