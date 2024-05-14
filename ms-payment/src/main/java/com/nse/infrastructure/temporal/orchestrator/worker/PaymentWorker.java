/**
 * 
 */
package com.nse.infrastructure.temporal.orchestrator.worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.DebitPaymentActivity;

import com.nse.infrastructure.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.task_queue.TaskQueue;

import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerOptions;
import jakarta.annotation.PostConstruct;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:44:15 pm
 */


public class PaymentWorker {
	Logger log = LoggerFactory.getLogger( PaymentWorker.class);
	
	  private final DebitPaymentActivity debitPaymentActivity;
	  private final WorkflowOrchestratorClient workflowOrchestratorClient;

	  /**
	 * @param debitPaymentActivity
	 * @param workflowOrchestratorClient
	 */
	public PaymentWorker(DebitPaymentActivity debitPaymentActivity,
			WorkflowOrchestratorClient workflowOrchestratorClient) {
		super();
		this.debitPaymentActivity = debitPaymentActivity;
		this.workflowOrchestratorClient = workflowOrchestratorClient;
	}

	@PostConstruct
	  public void createWorker() {

	    log.info("Registering Payment worker..");

	    var workflowClient = workflowOrchestratorClient.getWorkflowClient();

	    var workerOptions = WorkerOptions.newBuilder().build();

	    var workerFactory = WorkerFactory.newInstance(workflowClient);
	    var worker =
	        workerFactory.newWorker(TaskQueue.PAYMENT_ACTIVITY_TASK_QUEUE.name(), workerOptions);

	    worker.registerActivitiesImplementations(debitPaymentActivity);

	    workerFactory.start();

	    log.info("Registered Payment worker..");
	  }
}
