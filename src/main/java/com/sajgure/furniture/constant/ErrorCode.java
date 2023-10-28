/**
 * 
 */
package com.sajgure.furniture.constant;

/**
 * @author 
 *Shivaji Deotale
 */
public enum ErrorCode {

	DATA_BINDING(1001,"Data binding error"),
	
	JSON_FORMAT(1002,"Wrong Json format");
    
	private int errorCode;
	private String message;
	
    private ErrorCode(int errorCode,String message) {
            this.errorCode = errorCode;
            this.message=message;
    }
    
    public int errorCode() { return this.errorCode;}
    public String message() { return this.message;}
}
