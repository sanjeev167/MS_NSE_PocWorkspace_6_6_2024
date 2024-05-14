/**
 * 
 */
package com.nse.persistance.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.persistance.repository.model.InventoryPersistable;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 11:01:57 pm
 */
public interface InventoryJpaRepository extends JpaRepository<InventoryPersistable, Long> {

}
