/**
 * 
 */
package com.nse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.entities.ShipmentPersistable;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:52:35 pm
 */
public interface ShipmentJpaRepository extends JpaRepository<ShipmentPersistable, Long>{

}
