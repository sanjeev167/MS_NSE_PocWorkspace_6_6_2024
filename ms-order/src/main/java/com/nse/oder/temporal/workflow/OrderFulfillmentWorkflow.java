/**
 * 
 */
package com.nse.oder.temporal.workflow;

import com.nse.model.OrderDTO;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 12:03:57 pm
 * Objective: Here, we are declaring an OrderFulfillmentWorkflow interface and marking as @WorkflowInterface. It has one workflow method 
 * called createOrder() and mark it as @WorkflowMethod. When we start this workflow, only this workflow method will be called.
 */
@WorkflowInterface
public interface OrderFulfillmentWorkflow {
	 @WorkflowMethod
	  void createOrder(OrderDTO orderDTO);
}
