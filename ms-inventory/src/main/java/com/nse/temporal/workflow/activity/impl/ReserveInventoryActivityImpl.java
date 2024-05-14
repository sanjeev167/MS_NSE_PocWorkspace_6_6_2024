/**
 * 
 */
package com.nse.temporal.workflow.activity.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.ReserveInventoryActivity;
import com.nse.application.domain.model.Inventory;
import com.nse.application.domain.repository.InventoryRepository;
import com.nse.model.OrderDTO;

/**
 * @author sanjeevkumar 
 * 10-May-2024 
 * 12:16:09 am
 */

public class ReserveInventoryActivityImpl implements ReserveInventoryActivity {

	Logger log = LoggerFactory.getLogger(ReserveInventoryActivityImpl.class);

	private final InventoryRepository inventoryRepository;

	/**
	 * @param inventoryRepository
	 */
	public ReserveInventoryActivityImpl(InventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public void reserveInventory(OrderDTO orderDTO) {

		log.info("Processing inventory for order {}", orderDTO.getOrderId());

		var inventory = new Inventory();

		inventory.setOrderId(orderDTO.getOrderId());
		inventory.setProductId(orderDTO.getProductId());
		inventory.setQuantity(orderDTO.getQuantity());

		inventoryRepository.save(inventory);

		log.info("Finished processing inventory for order {}", orderDTO.getOrderId());
	}
}// End of ReserveInventoryActivityImpl
