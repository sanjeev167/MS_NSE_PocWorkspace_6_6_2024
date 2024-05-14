/**
 * 
 */
package com.nse.application.domain.repository;

import java.util.List;

import com.nse.application.domain.model.Inventory;

/**
 * @author sanjeevkumar
 * 10-May-2024
 * 12:06:22 am
 */
public interface InventoryRepository {

	Inventory save(Inventory inventory);
	List<Inventory> getAll();
}
