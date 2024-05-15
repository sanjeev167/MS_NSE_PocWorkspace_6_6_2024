/**
 * 
 */
package com.nse.temporal.workflow.activity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.ShipGoodsActivity;
import com.nse.application.domain.model.Shipment;
import com.nse.application.domain.service.ShipmentService;
import com.nse.model.OrderDTO;
import com.nse.service.ShipmentLocalApiService;


/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:47:07 pm
 */
public class ShipGoodsActivityImpl implements ShipGoodsActivity {
	
	Logger log = LoggerFactory.getLogger(ShipGoodsActivityImpl.class);
	
	private final ShipmentService shipmentService;
	private final ShipmentLocalApiService shipmentLocalApiService;

	/**
	 * @param shipmentService
	 * @param shipmentLocalApiService
	 */
	public ShipGoodsActivityImpl(ShipmentService shipmentService, ShipmentLocalApiService shipmentLocalApiService) {
		super();
		this.shipmentService = shipmentService;
		this.shipmentLocalApiService = shipmentLocalApiService;
	}	

	@Override
	  public void shipGoods(OrderDTO orderDTO) {

	    log.info("Dispatching shipment,  order id {}", orderDTO.getOrderId());
	    var trackingId = shipmentService.shipGoods(orderDTO.getQuantity());
	    
	    var shipment = new Shipment(orderDTO.getOrderId(), orderDTO.getProductId(), trackingId, orderDTO.getQuantity());        
	    
	    shipmentLocalApiService.save(shipment);

	    log.info("Created shipment for order id {}", orderDTO.getOrderId());
	  }
}
