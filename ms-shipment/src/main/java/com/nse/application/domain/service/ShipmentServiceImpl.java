/**
 * 
 */
package com.nse.application.domain.service;

import java.util.UUID;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:34:14 pm
 */
public class ShipmentServiceImpl implements ShipmentService{
	 @Override
	  public String shipGoods(Double quantity) {
	    UUID uuid = UUID.randomUUID();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return uuid.toString();
	  }
}
