/**
 * 
 */
package com.nse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.ReserveInventoryActivity;
import com.nse.application.domain.repository.InventoryRepository;
import com.nse.application.domain.repository.InventoryRepositoryImpl;
import com.nse.persistance.repository.jpa.InventoryJpaRepository;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.temporal.worker.InventoryWorker;
import com.nse.temporal.workflow.activity.impl.ReserveInventoryActivityImpl;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 11:15:39 pm
 */
@Configuration
public class InventoryServiceAppConfig {
	
	@Bean
	  public InventoryWorker inventoryWorker(InventoryJpaRepository inventoryJpaRepository) {
	    return new InventoryWorker(
	        reserveInventoryActivity(inventoryJpaRepository), workflowOrchestratorClient());
	  }

	  @Bean
	  public ReserveInventoryActivity reserveInventoryActivity(
	      InventoryJpaRepository inventoryJpaRepository) {
	    return new ReserveInventoryActivityImpl(inventoryRepository(inventoryJpaRepository));
	  }

	  @Bean
	  @ConfigurationProperties
	  public ApplicationProperties applicationProperties() {
	    return new ApplicationProperties();
	  }

	  @Bean
	  public WorkflowOrchestratorClient workflowOrchestratorClient() {
	    return new WorkflowOrchestratorClient(applicationProperties());
	  }

	  @Bean
	  public InventoryRepository inventoryRepository(InventoryJpaRepository inventoryJpaRepository) {
	    return new InventoryRepositoryImpl(inventoryJpaRepository);
	  }

}//End of InventoryServiceAppConfig 
