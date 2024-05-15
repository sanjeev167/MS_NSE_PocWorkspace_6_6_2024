/**
 * 
 */
package com.nse.ctrl;

import com.nse.domain.OrderStatus;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>12:24:56 pm
 * <br> Objective: OrderResponse will be used for responding and order request.
 */
public class OrderResponse {
	 private Long orderId;
	  private OrderStatus orderStatus;
	  public OrderResponse(Long orderId, OrderStatus orderStatus) {
	  this.orderId=orderId;
	   this.orderStatus=orderStatus;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	  
	  
}
