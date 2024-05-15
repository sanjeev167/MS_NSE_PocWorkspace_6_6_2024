/**
 * 
 */
package com.nse.service;

import java.util.List;

import com.nse.ctrl.Payment;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:35:38 pm
 */
public interface PaymentLocalService {
	Payment save(Payment payment);
	List<Payment> getAll();
}
