/**
 * 
 */
package com.nse.oder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:14:03 pm
 */
public interface OrderJpaRepository  extends JpaRepository<OrderPersistable, Long> {

}
