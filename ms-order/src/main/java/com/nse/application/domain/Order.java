/**
 * 
 */
package com.nse.application.domain;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:37:15 am
 * <br>Objective: This simple object has been created with an objective of processing an order at application
 * end. By application end we mean that it will be used within service and repository.
 * <br>Remark: We can use entity directly here. We will check it latter after running this project.
 */
public class Order {
	  private Long orderId;
	  private Long productId;
	  private Double price;
	  private Double quantity;
	  private OrderStatus orderStatus;
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
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
