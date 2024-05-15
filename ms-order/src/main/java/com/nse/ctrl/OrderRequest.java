/**
 * 
 */
package com.nse.ctrl;

import jakarta.validation.constraints.NotNull;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>12:23:18 pm
 * <br> Objective: This simple pojo class will be used for receiving and order from front-end via a controller. Different annotations of 
 * validation framework have been used over each property for validating the input before proceeding to process it.
 */
public class OrderRequest {
	
	 @NotNull(message = "Product ID is required.")
	 // @NotBlank(message = "Product ID cannot be blank.")
	  private Long productId;

	  @NotNull(message = "Price is required.")
	  private Double price;

	  @NotNull(message = "Quantity is required.")
	  private Double quantity;

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
	  
	  
}
