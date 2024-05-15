/**
 * 
 */
package com.nse.temporal.orchestrator;

import com.nse.domain.Order;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:44:57 am
 */
public interface WorkflowOrchestrator {
	 void createOrder(Order order);
}
