/**
 * 
 */
package com.nse.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.ShipGoodsActivity;
import com.nse.application.domain.repository.ShipmentRepository;
import com.nse.application.domain.service.ShipmentService;
import com.nse.application.domain.service.ShipmentServiceImpl;
import com.nse.infrastructure.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.infrastructure.temporal.orchestrator.worker.ShipmentWorker;
import com.nse.infrastructure.temporal.workflow.activity.impl.ShipGoodsActivityImpl;
import com.nse.persistence.repository.ShipmentRepositoryImpl;
import com.nse.persistence.repository.jpa.ShipmentJpaRepository;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:38:29 pm
 */
@Configuration
public class ShipmentServiceAppConfig {
	 @Bean
	  public ShipmentWorker shipmentWorker(ShipmentJpaRepository shipmentJpaRepository) {
	    return new ShipmentWorker(
	        shipGoodsActivity(shipmentJpaRepository), workflowOrchestratorClient());
	  }

	  @Bean
	  public ShipGoodsActivity shipGoodsActivity(ShipmentJpaRepository shipmentJpaRepository) {
	    return new ShipGoodsActivityImpl(shipmentService(), shipmentRepository(shipmentJpaRepository));
	  }

	  @Bean
	  public ShipmentService shipmentService() {
	    return new ShipmentServiceImpl();
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
	  public ShipmentRepository shipmentRepository(ShipmentJpaRepository shipmentJpaRepository) {
	    return new ShipmentRepositoryImpl(shipmentJpaRepository);
	  }
}
