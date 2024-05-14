/**
 * 
 */
package com.nse.error;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:26:08 pm
 */
public class ResourceNotFoundException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		    super(message);
		  }
}//End of ResourceNotFoundException 
