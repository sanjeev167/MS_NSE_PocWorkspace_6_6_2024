/**
 * 
 */
package com.nse.application.service.impl;

import java.util.UUID;

import com.nse.application.service.PaymentService;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:38:14 pm
 */
public class PaymentServiceImpl implements PaymentService {
	  @Override
	  public String debit(Double amount) {
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	  }
	}