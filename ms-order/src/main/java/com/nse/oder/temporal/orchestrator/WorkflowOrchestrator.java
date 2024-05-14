/**
 * 
 */
package com.nse.oder.temporal.orchestrator;

import com.nse.application.domain.Order;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:44:57 am
 */
public interface WorkflowOrchestrator {
	 void createOrder(Order order);
}
