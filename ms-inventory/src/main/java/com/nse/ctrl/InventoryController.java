/**
 * 
 */
package com.nse.ctrl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.model.Inventory;
import com.nse.service.InventoryService;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:51:25 pm
 */
@RestController
public class InventoryController {
	Logger log = LoggerFactory.getLogger(InventoryController.class);
	 @Autowired private InventoryService inventoryRepository;

	  @GetMapping("/inventories")
	  public ResponseEntity<List<Inventory>> listInventory() {
	    log.info("Getting all inventory..");
	    List<Inventory> inventories = inventoryRepository.getAll();
	    return new ResponseEntity<>(inventories, HttpStatus.OK);
	  }
}
