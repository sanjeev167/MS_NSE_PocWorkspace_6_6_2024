/**
 * 
 */
package com.nse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.ReserveInventoryActivity;
import com.nse.repo.InventoryJpaRepository;
import com.nse.service.InventoryService;
import com.nse.service.InventoryServiceImpl;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.temporal.worker.InventoryWorker;
import com.nse.temporal.workflow.activity.ReserveInventoryActivityImpl;

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
	  public InventoryService inventoryRepository(InventoryJpaRepository inventoryJpaRepository) {
	    return new InventoryServiceImpl(inventoryJpaRepository);
	  }

}//End of InventoryServiceAppConfig 
