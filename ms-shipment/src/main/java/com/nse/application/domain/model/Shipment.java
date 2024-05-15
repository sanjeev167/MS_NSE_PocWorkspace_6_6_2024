/**
 * 
 */
package com.nse.application.domain.model;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:30:18 pm
 */
public class Shipment {
	  private Long shipmentId;
	  private Long orderId;
	  private Long productId;
	  private String trackingId;
	  private Double quantity;
	  
	/**
	 * @param shipmentId
	 * @param orderId
	 * @param productId
	 * @param trackingId
	 * @param quantity
	 */
	public Shipment(Long orderId, Long productId, String trackingId, Double quantity) {
		super();
		
		this.orderId = orderId;
		this.productId = productId;
		this.trackingId = trackingId;
		this.quantity = quantity;
	}
	/**
	 * @return the shipmentId
	 */
	public Long getShipmentId() {
		return shipmentId;
	}
	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
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
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}
	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
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
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", orderId=" + orderId + ", productId=" + productId
				+ ", trackingId=" + trackingId + ", quantity=" + quantity + "]";
	}
	  
	  
}
