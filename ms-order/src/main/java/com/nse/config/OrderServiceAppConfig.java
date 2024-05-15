/**
 * 
 */
package com.nse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nse.activities.CompleteOrderActivity;
import com.nse.command.OrderCommand;
import com.nse.command.OrderCommandImpl;
import com.nse.factory.OrderFactory;
import com.nse.factory.OrderFactoryImpl;
import com.nse.query.OrderQuery;
import com.nse.query.OrderQueryImpl;
import com.nse.repo.OrderJpaRepository;
import com.nse.service.OrderService;
import com.nse.service.OrderServiceImpl;
import com.nse.temporal.activity.CompleteOrderActivityImpl;
import com.nse.temporal.orchestrator.WorkflowOrchestrator;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.temporal.orchestrator.WorkflowOrchestratorImpl;
import com.nse.temporal.worker.OrderWorker;

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
