/**
 * 
 */
package com.nse.service;

import java.util.List;

import com.nse.model.Inventory;

/**
 * @author sanjeevkumar
 * 10-May-2024
 * 12:06:22 am
 */
public interface InventoryService {

	Inventory save(Inventory inventory);
	List<Inventory> getAll();
}
