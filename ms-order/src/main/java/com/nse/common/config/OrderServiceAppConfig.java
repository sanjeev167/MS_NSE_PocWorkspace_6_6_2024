/**
 * 
 */
package com.nse.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nse.activities.CompleteOrderActivity;
import com.nse.application.command.OrderCommand;
import com.nse.application.command.OrderCommandImpl;
import com.nse.application.factory.OrderFactory;
import com.nse.application.factory.OrderFactoryImpl;
import com.nse.application.query.OrderQuery;
import com.nse.application.query.OrderQueryImpl;
import com.nse.oder.repo.OrderJpaRepository;
import com.nse.oder.service.OrderService;
import com.nse.oder.service.OrderServiceImpl;
import com.nse.oder.temporal.activity.impl.CompleteOrderActivityImpl;
import com.nse.oder.temporal.orchestrator.WorkflowOrchestrator;
import com.nse.oder.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.oder.temporal.orchestrator.WorkflowOrchestratorImpl;
import com.nse.oder.temporal.worker.OrderWorker;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:53:23 am
 * <br>Objective:
 */
@Configuration
public class OrderServiceAppConfig {
	@Bean
	  public OrderFactory orderFactory(OrderJpaRepository orderJpaRepository) {
	    return new OrderFactoryImpl(orderCommand(orderJpaRepository), orderQuery(orderJpaRepository));
	  }

	  private OrderQuery orderQuery(OrderJpaRepository orderJpaRepository) {
	    return new OrderQueryImpl(orderRepository(orderJpaRepository));
	  }

	  @Bean
	  public OrderCommand orderCommand(OrderJpaRepository orderJpaRepository) {
	    return new OrderCommandImpl(orderRepository(orderJpaRepository), workflowOrchestrator());
	  }

	  @Bean
	  public OrderWorker orderWorker(OrderJpaRepository orderJpaRepository) {
	    return new OrderWorker(
	        createPendingOrderActivity(orderJpaRepository), workflowOrchestratorClient());
	  }

	  @Bean
	  public CompleteOrderActivity createPendingOrderActivity(OrderJpaRepository orderJpaRepository) {
	    return new CompleteOrderActivityImpl(orderRepository(orderJpaRepository));
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
	  public OrderService orderRepository(OrderJpaRepository orderJpaRepository) {
	    return new OrderServiceImpl(orderJpaRepository);
	  }

	  @Bean
	  public WorkflowOrchestrator workflowOrchestrator() {
	    return new WorkflowOrchestratorImpl(workflowOrchestratorClient(), applicationProperties());
	  }
}
