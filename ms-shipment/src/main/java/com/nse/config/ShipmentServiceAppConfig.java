/**
 * 
 */
package com.nse.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.ShipGoodsActivity;
import com.nse.application.domain.service.ShipmentService;
import com.nse.application.domain.service.ShipmentServiceImpl;
import com.nse.repo.ShipmentJpaRepository;
import com.nse.service.ShipmentLocalApiService;
import com.nse.service.ShipmentLocalApiServiceImpl;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.temporal.orchestrator.worker.ShipmentWorker;
import com.nse.temporal.workflow.activity.ShipGoodsActivityImpl;
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
	    return new ShipGoodsActivityImpl(shipmentService(shipmentJpaRepository), shipmentLocalApiService(shipmentJpaRepository));
	  }

	  @Bean
	  public ShipmentService shipmentService(ShipmentJpaRepository shipmentJpaRepository) {
	    return new ShipmentServiceImpl(shipmentJpaRepository);
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
	  public ShipmentLocalApiService shipmentLocalApiService(ShipmentJpaRepository shipmentJpaRepository) {
	    return new ShipmentLocalApiServiceImpl(shipmentJpaRepository);
	  }
}
