/**
 * 
 */
package com.nse.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.persistence.repository.model.PaymentPersistable;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:02:23 pm
 */
public interface PaymentJpaRepository extends JpaRepository<PaymentPersistable, Long>{

}
