package com.nse.temporal.orchestrator;
import com.nse.config.ApplicationProperties;
import com.nse.domain.Order;
import com.nse.model.OrderDTO;
import com.nse.task_queue.TaskQueue;
import com.nse.temporal.workflow.OrderFulfillmentWorkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:59:31 am
 * <br>Objective: WorkflowOrchestratorImpl starts a workflow for an order using a temporal workflowClient. WorkflowClient requires an
 *  OrderFulfillmentWorkflow instance for creating a new newWorkflowStub. This OrderFulfillmentWorkflow instance is passed to start method
 *  of workflowClient along with an orderDTO object.  While creating OrderFulfillmentWorkflow, the control goes inside orderFulfillmentWorkflow
 *  and there it prepares activities and workflow. 
 */
public class WorkflowOrchestratorImpl 	implements WorkflowOrchestrator {

		private final WorkflowOrchestratorClient workflowOrchestratorClient;
		private final ApplicationProperties applicationProperties;

		public WorkflowOrchestratorImpl(WorkflowOrchestratorClient workflowOrchestratorClient,	ApplicationProperties applicationProperties) {
		this.workflowOrchestratorClient=workflowOrchestratorClient;
		this.applicationProperties=applicationProperties;
		}

		@Override
		  public void createOrder(Order order) {
		    var orderDTO = map(order);
		    var workflowClient = workflowOrchestratorClient.getWorkflowClient();
		    var orderFulfillmentWorkflowStub = workflowClient.newWorkflowStub(OrderFulfillmentWorkflow.class,
		                                                                                 WorkflowOptions.newBuilder()
		                                                                                .setWorkflowId(applicationProperties.getWorkflowId() + "-" + orderDTO.getOrderId())
		                                                                                .setTaskQueue(TaskQueue.ORDER_FULFILLMENT_WORKFLOW_TASK_QUEUE.name())
		                                                                                .build());
		    // Execute Sync
		    // orderFulfillmentWorkflow.createOrder(orderDTO);
		    // Async execution
		    WorkflowClient.start(orderFulfillmentWorkflowStub::createOrder, orderDTO);
		  }//End of createOrder

	   /**
		  * @author sanjeevkumar
		  * This will be used to prepare OrderDTO
		  * @param order
		  * @return
		*/
		private OrderDTO map(Order order) {
		    var orderDTO = new OrderDTO();
		    orderDTO.setOrderId(order.getOrderId());
		    orderDTO.setProductId(order.getProductId());
		    orderDTO.setPrice(order.getPrice());
		    orderDTO.setQuantity(order.getQuantity());
		    return orderDTO;
		  }
}//End of WorkflowOrchestratorImpl
