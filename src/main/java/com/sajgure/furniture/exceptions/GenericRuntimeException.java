package com.sajgure.furniture.exceptions;

import com.sajgure.furniture.constant.ErrorCode;
import com.sajgure.furniture.constant.ExceptionErrorCode;

/**
 * {@code GenericRuntimeException} is the superclass of those user define
 * exceptions.
 * 
 * 
 */
public abstract class GenericRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public int errorCode;
	public String errorMesssage;
	public Throwable actualError;

	public GenericRuntimeException(ExceptionErrorCode errorCode,Throwable cause) {
		super();
		this.errorCode = errorCode.errorCode();
		this.errorMesssage = errorCode.message();
		this.actualError = cause;

	}
	
	public GenericRuntimeException(ErrorCode errorCode,Throwable cause) {
		super();
		this.errorCode = errorCode.errorCode();
		this.errorMesssage = errorCode.message();
		this.actualError = cause;

	}
	
	public GenericRuntimeException(int errorCode, String errorMesssage,Throwable cause) {
		super();
		this.errorCode = errorCode;
		this.errorMesssage = errorMesssage;
		this.actualError = cause;

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMesssage() {
		return errorMesssage;
	}

	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}

	public Throwable getActualErrorMesssage() {
		return actualError;
	}

	public void setActualErrorMesssage(Throwable actualErrorMesssage) {
		this.actualError = actualErrorMesssage;
	}

}
