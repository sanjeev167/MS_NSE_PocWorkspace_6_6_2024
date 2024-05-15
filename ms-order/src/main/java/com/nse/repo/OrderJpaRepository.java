/**
 * 
 */
package com.nse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.entities.ProductOrder;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:14:03 pm
 */
public interface OrderJpaRepository  extends JpaRepository<ProductOrder, Long> {

}
