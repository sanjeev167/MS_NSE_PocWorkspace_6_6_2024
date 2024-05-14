/**
 * 
 */
package com.nse.activities;

import com.nse.model.OrderDTO;

import io.temporal.activity.ActivityInterface;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:32:59 pm
 */
@ActivityInterface
public interface DebitPaymentActivity {

	void debitPayment(OrderDTO orderDTO);
	
}//End of DebitPaymentActivity 
