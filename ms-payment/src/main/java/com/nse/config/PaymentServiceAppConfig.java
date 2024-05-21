
package com.nse.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nse.activities.DebitPaymentActivity;
import com.nse.repo.PaymentJpaRepository;
import com.nse.service.PaymentLocalService;
import com.nse.service.PaymentLocalServiceImpl;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.temporal.orchestrator.worker.PaymentWorker;
import com.nse.temporal.orchestrator.workflow.activity.DebitPaymentActivityImpl;
import com.nse.service.PaymentGatewayService;
import com.nse.service.PaymentGatewayServiceImpl;
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
	  public PaymentGatewayService paymentService() {
	    return new PaymentGatewayServiceImpl();
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
	  public PaymentLocalService paymentRepository(PaymentJpaRepository paymentJpaRepository) {
	    return new PaymentLocalServiceImpl(paymentJpaRepository);
	  }
}
