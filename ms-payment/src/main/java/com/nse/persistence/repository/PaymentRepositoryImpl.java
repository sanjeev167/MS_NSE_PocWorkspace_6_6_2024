/**
 * 
 */
package com.nse.persistence.repository;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.model.Payment;
import com.nse.application.domain.repository.PaymentRepository;
import com.nse.persistence.mapper.PaymentPersistableMapper;
import com.nse.persistence.repository.jpa.PaymentJpaRepository;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:57:13 pm
 */
public class PaymentRepositoryImpl implements PaymentRepository {
	Logger log = LoggerFactory.getLogger( PaymentRepositoryImpl.class);
	
	  private final PaymentJpaRepository paymentJpaRepository;

	  public PaymentRepositoryImpl(PaymentJpaRepository paymentJpaRepository) {
	    this.paymentJpaRepository = paymentJpaRepository;
	  }

	  @Override
	  public Payment save(Payment payment) {
	    log.info("Saving Payment");
	    var paymentPersistable = PaymentPersistableMapper.MAPPER.map(payment);
	    paymentPersistable = paymentJpaRepository.save(paymentPersistable);
	    log.info("Payment saved, id {}", paymentPersistable.getId());
	    return PaymentPersistableMapper.MAPPER.map(paymentPersistable);
	  }

	  @Override
	  public List<Payment> getAll() {
	    log.info("Getting all payments from DB..");
	    var paymentPersistables = paymentJpaRepository.findAll();
	    return paymentPersistables.stream().map(PaymentPersistableMapper.MAPPER::map).toList();
	  }
}
