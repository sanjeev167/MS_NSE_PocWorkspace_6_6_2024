/**
 * 
 */
package com.nse.error;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:22:12 pm
 */
public class ErrorResponse {

	private String message;
	private String code;
	
	/**
	 * @param message
	 * @param code
	 */
	public ErrorResponse(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}//End of ErrorResponse 
