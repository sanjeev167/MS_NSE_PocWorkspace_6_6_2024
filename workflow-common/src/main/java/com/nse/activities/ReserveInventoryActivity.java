/**
 * 
 */
package com.nse.activities;

import com.nse.model.OrderDTO;

import io.temporal.activity.ActivityInterface;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:34:11 pm
 */
@ActivityInterface
public interface ReserveInventoryActivity {
	void reserveInventory(OrderDTO orderDTO);
}//End of ReserveInventoryActivity 
