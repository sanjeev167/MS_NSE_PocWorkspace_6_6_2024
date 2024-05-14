/**
 * 
 */
package com.nse.application.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.Order;
import com.nse.oder.service.OrderService;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:49:31 am
 */
public class OrderQueryImpl implements OrderQuery {
	Logger log = LoggerFactory.getLogger( OrderQueryImpl.class);
	
	  private final OrderService orderService;

	  public OrderQueryImpl(OrderService orderService) {
		this.orderService=orderService;
	}

	@Override
	  public Order getOrder(Long orderId) {
	    log.info("Fetching Order for id {}", orderId);
	    return orderService.get(orderId);
	  }
}
