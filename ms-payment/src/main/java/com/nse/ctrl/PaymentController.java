/**
 * 
 */
package com.nse.ctrl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.service.PaymentLocalService;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:03:54 pm
 */
@RestController
public class PaymentController {
	Logger log = LoggerFactory.getLogger(PaymentController .class);
	
	@Autowired 
	private PaymentLocalService paymentRepository;

	  @GetMapping("/payments")
	  public ResponseEntity<List<Payment>> listPayments() {
	    log.info("Getting all payments..");
	    // For simplicity, keep API model same as domain model
	    List<Payment> payments = paymentRepository.getAll();
	    return new ResponseEntity<>(payments, HttpStatus.OK);
	  }
}
