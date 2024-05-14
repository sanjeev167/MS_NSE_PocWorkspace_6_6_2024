/**
 * 
 */
package com.nse.activities;

import com.nse.model.OrderDTO;

import io.temporal.activity.ActivityInterface;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:31:23 pm
 */

@ActivityInterface
public interface CompleteOrderActivity {
	void completeOrder(OrderDTO order);	
}//End of CompleteOrderActivity 
