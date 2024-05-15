/**
 * 
 */
package com.nse.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nse.factory.OrderFactory;

import jakarta.validation.Valid;
/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>12:18:01 pm
 * <br> Objective: 
 */
@RestController
public class OrderController {
	Logger log = LoggerFactory.getLogger( OrderController.class);
	
	 @Autowired 
	 private OrderFactory orderFactory;

	  @PostMapping("/orders")
	  public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {

	    log.info("Creating order, product id {}", orderRequest.getProductId());
	    var order = OrderRequestMapper.MAPPER.map(orderRequest);
	    var orderCommand = orderFactory.getOrderCommand();
	    var pendingOrder = orderCommand.createOrder(order);
	    var orderResponse = new OrderResponse(pendingOrder.getOrderId(), pendingOrder.getOrderStatus());
	    return new ResponseEntity<>(orderResponse, HttpStatus.ACCEPTED);
	  }

	  @GetMapping("/orders/{orderId}")
	  public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {
	    log.info("Getting order, id {}", orderId);
	    var orderQuery = orderFactory.getOrderQuery();
	    var order = orderQuery.getOrder(orderId);
	    var orderResponse = new OrderResponse(order.getOrderId(), order.getOrderStatus());
	    return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	  }
}
