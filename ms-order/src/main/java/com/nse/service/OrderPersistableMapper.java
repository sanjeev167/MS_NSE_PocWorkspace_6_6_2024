/**
 * 
 */
package com.nse.service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.nse.domain.Order;
import com.nse.repo.OrderPersistable;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:15:41 pm
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OrderPersistableMapper {
	public static final OrderPersistableMapper MAPPER =
		      Mappers.getMapper(OrderPersistableMapper.class);

		  @Mapping(source = "orderId", target = "id")
		  public abstract OrderPersistable map(Order order);

		  @Mapping(source = "id", target = "orderId")
		  public abstract Order map(OrderPersistable orderPersistable);
}
	