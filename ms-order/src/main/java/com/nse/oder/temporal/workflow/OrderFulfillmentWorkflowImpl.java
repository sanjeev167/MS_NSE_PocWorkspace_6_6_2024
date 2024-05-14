/**
 * 
 */
package com.nse.oder.temporal.workflow;

import java.time.Duration;

import org.slf4j.Logger;

import com.nse.activities.CompleteOrderActivity;
import com.nse.activities.DebitPaymentActivity;
import com.nse.activities.ReserveInventoryActivity;
import com.nse.activities.ShipGoodsActivity;
import com.nse.model.OrderDTO;
import com.nse.task_queue.TaskQueue;

import io.temporal.activity.ActivityOptions;
import io.temporal.activity.LocalActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:05:09 pm
 * Objective: This OrderFulfillmentWorkflowImpl class will override will override single method declared within OrderFulfillmentWorkflow 
 * interface. Before overriding this method, we need to prepare followings.
 * [1] We need to prepare an activity stub instance corresponding to each activity which will participate in the workflow.
 * [2] Each activity stub will be created using its corresponding activity option.
 * [3] Each activity option will be defined with its own parameter setting. 
 * <br>They are
 *  <br>(a) setStartToCloseTimeout: This time is set as minute value. It decides how much time it could take to start and close the activity.
 *  <br>(b) setTaskQueue: An activity needs a unique taskQueue name which could differentiate it from other tastQueue.
 *  <br>(b) setRetryOptions: This option is set with an objective of retrying this task from Temporal server.
 *  
 *  Remark: 
 *  [1]All activities participating in the workflow will be registered at Temporal server as an stub and whatever activity details have been set
 *  in its activity option will be executed accordingly by Temporal Server.
 *  [2] Every activity stub creation is using an interface of an activity which will be implemented by the respective activity tackling micro service.
 *  This stub concept is used for making a RPC call from Temporal Server.
 *  [3] Under its workflow method createOrder(), we will call the respective method of different activity, which is actually defined in its respective
 *  micro-service, via this activity stub.
 *  [4] Calling of these stubs method should be in the same sequence in which the business demands.
 *  [5] The workflow initiator is called local activity.
 */
public class OrderFulfillmentWorkflowImpl implements OrderFulfillmentWorkflow {

	  private Logger logger = Workflow.getLogger(this.getClass().getName());
	  
	  private int startToCloseTimeout4Activity=1;
	  private int maxAttemptsCount4Activity=3;
	  
	  private int startToCloseTimeout4Local=1;
	  private int maxAttemptsCount4Local=10;

	  private final ActivityOptions paymentActivityOptions = ActivityOptions.newBuilder()
																				              .setStartToCloseTimeout(Duration.ofMinutes(startToCloseTimeout4Activity))
																				              .setTaskQueue(TaskQueue.PAYMENT_ACTIVITY_TASK_QUEUE.name())
																				               .setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(maxAttemptsCount4Activity).build())
																				               .build();
	  
	  private final ActivityOptions inventoryActivityOptions = ActivityOptions.newBuilder()
																				              .setStartToCloseTimeout(Duration.ofMinutes(startToCloseTimeout4Activity))
																				              .setTaskQueue(TaskQueue.INVENTORY_ACTIVITY_TASK_QUEUE.name())
																				              .setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(maxAttemptsCount4Activity).build())
																				               .build();
	  private final ActivityOptions shippingActivityOptions = ActivityOptions.newBuilder()
	                                                                                        .setStartToCloseTimeout(Duration.ofMinutes(startToCloseTimeout4Activity))
	                                                                                        .setTaskQueue(TaskQueue.SHIPPING_ACTIVITY_TASK_QUEUE.name())
	                                                                                        .setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(maxAttemptsCount4Activity).build())
	                                                                                         .build();	  
	  private final LocalActivityOptions localActivityOptions = LocalActivityOptions.newBuilder()
	                                                                                          .setStartToCloseTimeout(Duration.ofMinutes(startToCloseTimeout4Local))
	                                                                                          .setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(maxAttemptsCount4Local).build())
	                                                                                          .build();
	  private final DebitPaymentActivity paymentActivity =
                                                                                        Workflow.newActivityStub(DebitPaymentActivity.class, paymentActivityOptions);
	  private final ReserveInventoryActivity reserveInventoryActivity =
                                                                                       Workflow.newActivityStub(ReserveInventoryActivity.class, inventoryActivityOptions);
	  private final ShipGoodsActivity shipGoodsActivity = 
                                                                                       Workflow.newActivityStub(ShipGoodsActivity.class, shippingActivityOptions);
	  private final CompleteOrderActivity orderActivity =
			                                                                           Workflow.newLocalActivityStub(CompleteOrderActivity.class, localActivityOptions);

	  @Override
	  public void createOrder(OrderDTO orderDTO) {
		  
	    logger.info("Workflow ID {}", Workflow.getInfo().getWorkflowId());

	    logger.info("Debiting payment..");
	    paymentActivity.debitPayment(orderDTO);

	    logger.info("Reserving inventory..");
	    reserveInventoryActivity.reserveInventory(orderDTO);

	    logger.info("Shipping goods..");
	    shipGoodsActivity.shipGoods(orderDTO);

	    logger.info("Completing order..");
	    orderActivity.completeOrder(orderDTO);
	  }
}//End of OrderFulfillmentWorkflowImpl
