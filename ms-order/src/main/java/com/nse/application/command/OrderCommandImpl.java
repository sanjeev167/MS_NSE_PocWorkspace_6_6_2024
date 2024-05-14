package com.nse.application.command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.Order;
import com.nse.application.domain.OrderStatus;
import com.nse.oder.service.OrderService;
import com.nse.oder.temporal.orchestrator.WorkflowOrchestrator;
/**
 * @author sanjeevkumar 
 * <br>11-May-2024 
 * <br>11:35:08 am
 * <br> Objective: Here, OrderCommand has two jobs. One is to persist the coming order in the database as a pending order and initiate 
 * its workflow through workflowOrchestrator.
 * <br> The reason of keeping an order in pending state is that its different activities of workflow yet to be completed. This will be updated 
 * once its defined workflow completes its all tasks.
 */
public class OrderCommandImpl implements OrderCommand {
	Logger log = LoggerFactory.getLogger(OrderCommandImpl.class);

	private final OrderService orderService;
	private final WorkflowOrchestrator workflowOrchestrator;

	public OrderCommandImpl(OrderService orderService, WorkflowOrchestrator workflowOrchestrator) {
		this.orderService = orderService;
		this.workflowOrchestrator = workflowOrchestrator;
	}

	@Override
	public Order createOrder(Order order) {
		log.info("Creating order..");
		order.setOrderStatus(OrderStatus.PENDING);
		var persistedOrder = orderService.save(order);
		workflowOrchestrator.createOrder(persistedOrder);
		return persistedOrder;
	}
}
