/**
 * 
 */
package com.nse.persistence.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.nse.application.domain.model.Payment;
import com.nse.persistence.repository.model.PaymentPersistable;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:54:38 pm
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PaymentPersistableMapper {
	 public static final PaymentPersistableMapper MAPPER =
		      Mappers.getMapper(PaymentPersistableMapper.class);

		  @Mapping(source = "paymentId", target = "id")
		  public abstract PaymentPersistable map(Payment payment);

		  @Mapping(source = "id", target = "paymentId")
		  public abstract Payment map(PaymentPersistable paymentPersistable);
}
