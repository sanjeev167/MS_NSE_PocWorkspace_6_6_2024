/**
 * 
 */
package com.nse.infrastructure.temporal.workflow.activity.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.DebitPaymentActivity;
import com.nse.application.domain.model.Payment;
import com.nse.application.domain.repository.PaymentRepository;
import com.nse.application.service.PaymentService;
import com.nse.model.OrderDTO;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:51:13 pm
 */
public class DebitPaymentActivityImpl implements DebitPaymentActivity {
	Logger log = LoggerFactory.getLogger( DebitPaymentActivityImpl.class);
	
	  private final PaymentService paymentService;
	  private final PaymentRepository paymentRepository;

	  /**
	 * @param paymentService
	 * @param paymentRepository
	 */
	public DebitPaymentActivityImpl(PaymentService paymentService, PaymentRepository paymentRepository) {
		super();
		this.paymentService = paymentService;
		this.paymentRepository = paymentRepository;
	}

	@Override
	  public void debitPayment(OrderDTO orderDTO) {
	    log.info("Processing payment for order {}", orderDTO.getOrderId());
	    double amount = orderDTO.getQuantity() * orderDTO.getPrice();
	    // Call external Payment service such as Stripe
	    var externalPaymentId = paymentService.debit(amount);
	    // Create domain object
	    var payment =  new Payment(externalPaymentId,orderDTO.getOrderId(),orderDTO.getProductId(), amount); 	          
	    paymentRepository.save(payment);
	  }
}
