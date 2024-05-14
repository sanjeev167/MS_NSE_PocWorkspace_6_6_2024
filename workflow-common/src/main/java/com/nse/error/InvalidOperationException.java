/**
 * 
 */
package com.nse.error;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:24:49 pm
 */
public class InvalidOperationException extends RuntimeException {
	  
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(String message) {
		    super(message);
		  }
}//End of InvalidOperationException 
