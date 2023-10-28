package com.sajgure.furniture.exceptions;

import com.sajgure.furniture.constant.ExceptionErrorCode;

/**
 * {@code DatabaseException} is thrown by service layer when 
 * DAO layer throw HibernateException
 *
 */
public class DAOException extends GenericRuntimeException {
	
	private static final long serialVersionUID = 1L;	
	
	public DAOException(ExceptionErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);		
	}

	public DAOException(int errorCode, String errorMesssage,
			Throwable actualError) {
		super(errorCode, errorMesssage, actualError);
		this.errorCode=errorCode;
		this.errorMesssage=errorMesssage;
		this.actualError=actualError;
	}
	
}
