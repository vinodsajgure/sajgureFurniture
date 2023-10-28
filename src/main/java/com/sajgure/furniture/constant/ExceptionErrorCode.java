/**
 * 
 */
package com.sajgure.furniture.constant;


public enum ExceptionErrorCode {

	REQUEST_PARAMETER_NOT_FOUND(1001,"Request Parameter not found."),
	
	USER_NOT_FOUND(2001,"User not found."),
	
	FILE_NOT_UPLOAD(2002,"File not upload. Please try later."),
	
	DAO_EXCEPTION(2003,"Internal server error. Please try later."),
	
	GENERIC_RUNTIME_ERROR(2004,"Please try after some time or Please contact support"),
	
	REQUEST_NOT_ASSOCIATE_WITH_ORG(2005,"Requestid is not associate with your organization"),
	
	DATABASE_CONNECTION_ERROR(2006,"Server is down please try after some time"),
	
	HTTP_SESSION_EXCEPTION(2007,"Your session expired try after some time"),
	
	NULL_POINTER_EXCEPTION(2008,"The argument cannot be null"),
	 
	DATE_PARSE_EXCEPTION(2009,"Wrong date format"),
	
	INTEGRITY_VIOLATION_EXCEPTION(2010,"Wrong id provided"),
	
	FILE_UPLOAD_EXTENSION(2011,"file upload extension"),
	
	FILE_CONTENT_EXTENSION(2012,"file content extension");
	
	private int errorCode;
	private String message;
	
    private ExceptionErrorCode(int errorCode,String message) {
            this.errorCode = errorCode;
            this.message=message;
    }
    
    public int errorCode() { return this.errorCode;}
    public String message() { return this.message;}
}
