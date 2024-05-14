/**
 * 
 */
package com.nse.application.domain.repository;

import java.util.List;

import com.nse.application.domain.model.Payment;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:35:38 pm
 */
public interface PaymentRepository {
	Payment save(Payment payment);

	  List<Payment> getAll();
}
