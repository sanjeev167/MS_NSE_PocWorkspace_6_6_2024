/**
 * 
 */
package com.nse.temporal.orchestrator.worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.activities.ShipGoodsActivity;
import com.nse.task_queue.TaskQueue;
import com.nse.temporal.orchestrator.WorkflowOrchestratorClient;

import io.temporal.client.WorkflowClient;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PostConstruct;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:44:01 pm
 */
public class ShipmentWorker {
	Logger log = LoggerFactory.getLogger(ShipmentWorker.class);
	
	private final ShipGoodsActivity shipGoodsActivity;
	  private final WorkflowOrchestratorClient workflowOrchestratorClient;

	  
	  
	  /**
	 * @param shipGoodsActivity
	 * @param workflowOrchestratorClient
	 */
	public ShipmentWorker(ShipGoodsActivity shipGoodsActivity, WorkflowOrchestratorClient workflowOrchestratorClient) {
		super();
		this.shipGoodsActivity = shipGoodsActivity;
		this.workflowOrchestratorClient = workflowOrchestratorClient;
	}



	@PostConstruct
	  public void createWorker() {

	    log.info("Registering worker..");

	    WorkflowClient workflowClient = workflowOrchestratorClient.getWorkflowClient();

	    WorkerFactory workerFactory = WorkerFactory.newInstance(workflowClient);
	    Worker worker = workerFactory.newWorker(TaskQueue.SHIPPING_ACTIVITY_TASK_QUEUE.name());

	    worker.registerActivitiesImplementations(shipGoodsActivity);

	    workerFactory.start();

	    log.info("Shipment worker started..");
	  }
}
