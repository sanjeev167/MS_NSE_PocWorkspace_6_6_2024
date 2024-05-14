/**
 * 
 */
package com.nse.persistence.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.nse.application.domain.model.Shipment;
import com.nse.persistence.repository.model.ShipmentPersistable;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:49:28 pm
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public  abstract class ShipmentPersistableMapper {
	public static final ShipmentPersistableMapper MAPPER =
		      Mappers.getMapper(ShipmentPersistableMapper.class);

		  @Mapping(source = "shipmentId", target = "id")
		  public abstract ShipmentPersistable map(Shipment shipment);

		  @Mapping(source = "id", target = "shipmentId")
		  public abstract Shipment map(ShipmentPersistable shipmentPersistable);
}