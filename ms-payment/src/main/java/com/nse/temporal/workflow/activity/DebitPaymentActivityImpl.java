/**
 * 
 */
package com.nse.temporal.workflow.activity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.DebitPaymentActivity;
import com.nse.ctrl.Payment;
import com.nse.model.OrderDTO;
import com.nse.service.PaymentLocalService;
import com.nse.service.PaymentGatewayService;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:51:13 pm
 */
public class DebitPaymentActivityImpl implements DebitPaymentActivity {
	Logger log = LoggerFactory.getLogger( DebitPaymentActivityImpl.class);
	
	  private final PaymentGatewayService paymentGatewayService;
	  private final PaymentLocalService paymentLocalService;

	  /**
	 * @param paymentService
	 * @param paymentRepository
	 */
	public DebitPaymentActivityImpl(PaymentGatewayService paymentGatewayService, PaymentLocalService paymentLocalService) {
		super();
		this.paymentGatewayService = paymentGatewayService;
		this.paymentLocalService = paymentLocalService;
	}

	@Override
	  public void debitPayment(OrderDTO orderDTO) {
	    log.info("Processing payment for order {}", orderDTO.getOrderId());
	    double amount = orderDTO.getQuantity() * orderDTO.getPrice();
	    // Call external Payment service such as Stripe
	    var externalPaymentId = paymentGatewayService.debit(amount);
	    // Create domain object
	    var payment =  new Payment(externalPaymentId,orderDTO.getOrderId(),orderDTO.getProductId(), amount); 	          
	    paymentLocalService.save(payment);
	  }
}
