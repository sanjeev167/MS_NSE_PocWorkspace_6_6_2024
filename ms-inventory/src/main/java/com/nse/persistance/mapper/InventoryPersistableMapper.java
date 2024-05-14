/**
 * 
 */
package com.nse.persistance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.nse.application.domain.model.Inventory;
import com.nse.persistance.repository.model.InventoryPersistable;


/**
 * @author sanjeevkumar 
 * 09-May-2024 
 * 10:55:13 pm
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class InventoryPersistableMapper {

	public static final InventoryPersistableMapper MAPPER = Mappers.getMapper(InventoryPersistableMapper.class);

	@Mapping(source = "inventoryId", target = "id")
	public abstract InventoryPersistable map(Inventory inventory);

	@Mapping(source = "id", target = "inventoryId")
	public abstract Inventory map(InventoryPersistable inventoryPersistable);

}// End of InventoryPersistableMapper
