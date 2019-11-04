package com.xm.ssit.demo.exception;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/11/4 10:25
 * Verion 1.0
 **/
public class BusinessException extends RuntimeException{
	private String code;
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
}
