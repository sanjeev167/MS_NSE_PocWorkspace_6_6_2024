/**
 * 
 */
package com.nse.activities;

import com.nse.model.OrderDTO;

import io.temporal.activity.ActivityInterface;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 10:35:12 pm
 */

@ActivityInterface
public interface ShipGoodsActivity {
	void shipGoods(OrderDTO orderDTO);
}//End of ShipGoodsActivity 
