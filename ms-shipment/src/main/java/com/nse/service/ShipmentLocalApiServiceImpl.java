/**
 * 
 */
package com.nse.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.model.Shipment;
import com.nse.entities.ShipmentPersistable;
import com.nse.repo.ShipmentJpaRepository;

import com.nse.repo.ShipmentPersistableMapper;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:56:10 pm
 */
public class ShipmentLocalApiServiceImpl implements ShipmentLocalApiService {
	Logger log = LoggerFactory.getLogger(ShipmentLocalApiServiceImpl.class);
	
	  private final ShipmentJpaRepository shipmentJpaRepository;

	  public ShipmentLocalApiServiceImpl(ShipmentJpaRepository shipmentJpaRepository) {
	    this.shipmentJpaRepository = shipmentJpaRepository;
	  }

	  @Override
	  public Shipment save(Shipment shipment) {
	    log.info("Saving Shipment");
	    ShipmentPersistable shipmentPersistable = ShipmentPersistableMapper.MAPPER.map(shipment);
	    shipmentPersistable = shipmentJpaRepository.save(shipmentPersistable);
	    log.info("Shipment saved, id {}", shipmentPersistable.getId());
	    return ShipmentPersistableMapper.MAPPER.map(shipmentPersistable);
	  }

	  @Override
	  public List<Shipment> getAll() {
	    log.info("Getting all shipments from DB..");
	    var shipmentPersistables = shipmentJpaRepository.findAll();
	    return shipmentPersistables.stream().map(ShipmentPersistableMapper.MAPPER::map).toList();
	  }
	}
