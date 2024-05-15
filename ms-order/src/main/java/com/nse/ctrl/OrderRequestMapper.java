	/**
 * 
 */
package com.nse.ctrl;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.nse.domain.Order;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:26:56 pm
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OrderRequestMapper {
	
	public static final OrderRequestMapper MAPPER = Mappers.getMapper(OrderRequestMapper.class);

	public abstract Order map(OrderRequest request);
}
