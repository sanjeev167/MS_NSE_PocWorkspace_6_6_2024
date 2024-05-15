/**
 * 
 */
package com.nse.persistance.repository;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.model.Inventory;
import com.nse.application.domain.repository.InventoryRepository;
import com.nse.persistance.mapper.InventoryPersistableMapper;
import com.nse.persistance.repository.jpa.InventoryJpaRepository;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:41:48 pm
 */
public class InventoryRepositoryImpl implements InventoryRepository {
	Logger log = LoggerFactory.getLogger(InventoryRepositoryImpl.class);
	  private final InventoryJpaRepository inventoryJpaRepository;

	  public InventoryRepositoryImpl(InventoryJpaRepository inventoryJpaRepository) {
	    this.inventoryJpaRepository = inventoryJpaRepository;
	  }

	  @Override
	  public Inventory save(Inventory inventory) {
	    log.info("Saving Inventory");
	    var inventoryPersistable = InventoryPersistableMapper.MAPPER.map(inventory);
	    inventoryPersistable = inventoryJpaRepository.save(inventoryPersistable);
	    log.info("Inventory saved, id {}", inventoryPersistable.getId());
	    return InventoryPersistableMapper.MAPPER.map(inventoryPersistable);
	  }

	  @Override
	  public List<Inventory> getAll() {
	    log.info("Getting all inventory from DB..");
	    var inventoryPersistables = inventoryJpaRepository.findAll();
	    return inventoryPersistables.stream().map(InventoryPersistableMapper.MAPPER::map).toList();
	  }
	}