/**
 * 
 */
package com.nse.oder.temporal.activity.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.CompleteOrderActivity;
import com.nse.application.domain.Order;
import com.nse.application.domain.OrderStatus;
import com.nse.model.OrderDTO;
import com.nse.oder.service.OrderService;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:08:02 pm
 */
public class CompleteOrderActivityImpl 	implements CompleteOrderActivity {
	     Logger log = LoggerFactory.getLogger( CompleteOrderActivityImpl.class);
	
		  private final OrderService orderRepository;

		  public CompleteOrderActivityImpl(OrderService orderRepository) {
			this.orderRepository=orderRepository;
		}

		@Override
		  public void completeOrder(OrderDTO orderDTO) {
		    log.info("Marking order as completed, order id {}", orderDTO.getOrderId());
		    var order = map(orderDTO);
		    order.setOrderStatus(OrderStatus.COMPLETED);
		    var completedOrder = orderRepository.save(order);
		    log.info("Order completed, {}", completedOrder);
		  }

		  private Order map(OrderDTO orderDTO) {
		    var order = new Order();
		    order.setOrderId(orderDTO.getOrderId());
		    order.setProductId(orderDTO.getProductId());
		    order.setPrice(orderDTO.getPrice());
		    order.setQuantity(orderDTO.getQuantity());
		    return order;
		  }
}
