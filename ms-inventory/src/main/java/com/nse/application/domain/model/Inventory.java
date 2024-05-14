/**
 * 
 */
package com.nse.application.domain.model;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 11:23:24 pm
 */
public class Inventory {

	 private Long inventoryId;
	  private Long orderId;
	  private Long productId;
	  private Double quantity;
	/**
	 * @return the inventoryId
	 */
	public Long getInventoryId() {
		return inventoryId;
	}
	/**
	 * @param inventoryId the inventoryId to set
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
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
	  
	  
}//End of Inventory 
