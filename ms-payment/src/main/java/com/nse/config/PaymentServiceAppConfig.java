
package com.nse.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.DebitPaymentActivity;
import com.nse.application.domain.repository.PaymentRepository;
import com.nse.application.service.PaymentService;
import com.nse.application.service.impl.PaymentServiceImpl;
import com.nse.infrastructure.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.infrastructure.temporal.orchestrator.worker.PaymentWorker;
import com.nse.infrastructure.temporal.workflow.activity.impl.DebitPaymentActivityImpl;
import com.nse.persistence.repository.PaymentRepositoryImpl;
import com.nse.persistence.repository.jpa.PaymentJpaRepository;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:41:06 pm
 */
@Configuration
public class PaymentServiceAppConfig {
	 @Bean
	  public PaymentWorker paymentWorker(PaymentJpaRepository paymentJpaRepository) {
	    return new PaymentWorker(
	        debitPaymentActivity(paymentJpaRepository), workflowOrchestratorClient());
	  }

	  @Bean
	  public DebitPaymentActivity debitPaymentActivity(PaymentJpaRepository paymentJpaRepository) {
	    return new DebitPaymentActivityImpl(paymentService(), paymentRepository(paymentJpaRepository));
	  }

	  @Bean
	  public PaymentService paymentService() {
	    return new PaymentServiceImpl();
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
	  public PaymentRepository paymentRepository(PaymentJpaRepository paymentJpaRepository) {
	    return new PaymentRepositoryImpl(paymentJpaRepository);
	  }
}
