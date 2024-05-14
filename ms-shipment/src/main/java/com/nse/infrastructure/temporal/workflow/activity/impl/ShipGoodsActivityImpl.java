/**
 * 
 */
package com.nse.infrastructure.temporal.workflow.activity.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.ShipGoodsActivity;
import com.nse.application.domain.model.Shipment;
import com.nse.application.domain.repository.ShipmentRepository;
import com.nse.application.domain.service.ShipmentService;
import com.nse.model.OrderDTO;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:47:07 pm
 */
public class ShipGoodsActivityImpl implements ShipGoodsActivity {
	Logger log = LoggerFactory.getLogger(ShipGoodsActivityImpl.class);
	
	  private final ShipmentService shipmentService;
	  private final ShipmentRepository shipmentRepository;
	  
	  

	  /**
	 * @param shipmentService
	 * @param shipmentRepository
	 */
	public ShipGoodsActivityImpl(ShipmentService shipmentService, ShipmentRepository shipmentRepository) {
		super();
		this.shipmentService = shipmentService;
		this.shipmentRepository = shipmentRepository;
	}



	@Override
	  public void shipGoods(OrderDTO orderDTO) {

	    log.info("Dispatching shipment,  order id {}", orderDTO.getOrderId());
	    String trackingId = shipmentService.shipGoods(orderDTO.getQuantity());	   
	    Shipment shipment = new Shipment( orderDTO.getOrderId(), orderDTO.getProductId(), trackingId, orderDTO.getQuantity());
	            
	    shipmentRepository.save(shipment);

	    log.info("Created shipment for order id {}", orderDTO.getOrderId());
	  }
}
