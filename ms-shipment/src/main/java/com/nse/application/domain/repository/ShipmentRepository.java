/**
 * 
 */
package com.nse.application.domain.repository;

import java.util.List;

import com.nse.application.domain.model.Shipment;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:32:01 pm
 */
public interface ShipmentRepository {
	Shipment save(Shipment shipment);

	  List<Shipment> getAll();
}
