/**
 * 
 */
package com.nse.oder.temporal.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.CompleteOrderActivity;
import com.nse.oder.temporal.orchestrator.WorkflowOrchestratorClient;
import com.nse.oder.temporal.workflow.OrderFulfillmentWorkflowImpl;
import com.nse.task_queue.TaskQueue;

import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerOptions;
import io.temporal.worker.WorkflowImplementationOptions;
import jakarta.annotation.PostConstruct;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:02:12 pm
 */
public class OrderWorker {
	   Logger log = LoggerFactory.getLogger( OrderWorker.class);
	  private final CompleteOrderActivity completeOrderActivity;
	  private final WorkflowOrchestratorClient workflowOrchestratorClient;

	  public OrderWorker(CompleteOrderActivity createPendingOrderActivity,
			WorkflowOrchestratorClient workflowOrchestratorClient) {
		  this.completeOrderActivity=createPendingOrderActivity;
		  this.workflowOrchestratorClient=workflowOrchestratorClient;
	}

	@PostConstruct
	  public void createWorker() {

	    log.info("Registering worker..");

	    var workerOptions = WorkerOptions.newBuilder().build();

	    var workflowClient = workflowOrchestratorClient.getWorkflowClient();
	    WorkflowImplementationOptions workflowImplementationOptions =
	        WorkflowImplementationOptions.newBuilder()
	            .setFailWorkflowExceptionTypes(NullPointerException.class)
	            .build();

	    var workerFactory = WorkerFactory.newInstance(workflowClient);
	    var worker =
	        workerFactory.newWorker(
	            TaskQueue.ORDER_FULFILLMENT_WORKFLOW_TASK_QUEUE.name(), workerOptions);

	    // Can be called multiple times
	    worker.registerWorkflowImplementationTypes(
	        workflowImplementationOptions, OrderFulfillmentWorkflowImpl.class);

	    worker.registerActivitiesImplementations(completeOrderActivity);

	    workerFactory.start();

	    log.info("Registering order worker..");
	  }
}
