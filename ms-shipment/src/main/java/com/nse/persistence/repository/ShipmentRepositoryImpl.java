/**
 * 
 */
package com.nse.persistence.repository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.model.Shipment;
import com.nse.application.domain.repository.ShipmentRepository;
import com.nse.persistence.mapper.ShipmentPersistableMapper;
import com.nse.persistence.repository.jpa.ShipmentJpaRepository;
import com.nse.persistence.repository.model.ShipmentPersistable;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:56:10 pm
 */
public class ShipmentRepositoryImpl implements ShipmentRepository {
	Logger log = LoggerFactory.getLogger(ShipmentRepositoryImpl.class);
	
	  private final ShipmentJpaRepository shipmentJpaRepository;

	  public ShipmentRepositoryImpl(ShipmentJpaRepository shipmentJpaRepository) {
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
