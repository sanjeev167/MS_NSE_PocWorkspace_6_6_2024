/**
 * 
 */
package com.nse.service;

import java.util.List;

import com.nse.application.domain.model.Shipment;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:32:01 pm
 */
public interface ShipmentLocalApiService {
	Shipment save(Shipment shipment);
	List<Shipment> getAll();
}
