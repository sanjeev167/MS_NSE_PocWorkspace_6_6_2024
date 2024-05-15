/**
 * 
 */
package com.nse.service;

import java.util.UUID;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:38:14 pm
 */
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
	  
	@Override
	  public String debit(Double amount) {
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	  }
	
}