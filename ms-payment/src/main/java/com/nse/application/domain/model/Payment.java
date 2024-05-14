/**
 * 
 */
package com.nse.application.domain.model;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:34:17 pm
 */
public class Payment {
	  private Long paymentId;
	  private Long orderId;
	  private Long productId;
	  private Double amount;
	  private String externalId;
	  
	/**
	 * @param paymentId
	 * @param orderId
	 * @param productId
	 * @param amount
	 * @param externalId
	 */
	public Payment(String externalId,Long orderId,Long productId, Double amount) {
		super();
		this.externalId = externalId;
		this.orderId = orderId;
		this.productId = productId;		
		this.amount = amount;	
	}
	  
	/**
	 * @return the paymentId
	 */
	public Long getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the externalId
	 */
	public String getExternalId() {
		return externalId;
	}
	/**
	 * @param externalId the externalId to set
	 */
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	  
	  
}
