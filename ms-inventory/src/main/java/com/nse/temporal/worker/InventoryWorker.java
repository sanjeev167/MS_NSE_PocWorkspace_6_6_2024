/**
 * 
 */
package com.nse.temporal.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.ReserveInventoryActivity;
import com.nse.task_queue.TaskQueue;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;

import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerOptions;
import jakarta.annotation.PostConstruct;


/**
 * @author sanjeevkumar 
 * 09-May-2024 
 * 11:29:13 pm
 */

public class InventoryWorker {

	Logger log = LoggerFactory.getLogger(InventoryWorker.class);
	private final ReserveInventoryActivity reserveInventoryActivity;
	private final WorkflowOrchestratorClient workflowOrchestratorClient;

	
	/**
	 * @param reserveInventoryActivity
	 * @param workflowOrchestratorClient
	 */
	public InventoryWorker(ReserveInventoryActivity reserveInventoryActivity,
			WorkflowOrchestratorClient workflowOrchestratorClient) {
		super();
		this.reserveInventoryActivity = reserveInventoryActivity;
		this.workflowOrchestratorClient = workflowOrchestratorClient;
	}


	@PostConstruct
	public void createWorker() {

		log.info("Registering worker..");

		var workerOptions = WorkerOptions.newBuilder().build();
		
		var workflowClient = workflowOrchestratorClient.getWorkflowClient();		
		var workerFactory = WorkerFactory.newInstance(workflowClient);
		var worker = workerFactory.newWorker(TaskQueue.INVENTORY_ACTIVITY_TASK_QUEUE.name(), workerOptions);

		worker.registerActivitiesImplementations(reserveInventoryActivity);

		workerFactory.start();

		log.info("Inventory worker started..");
	}

}// End of InventoryWorker
