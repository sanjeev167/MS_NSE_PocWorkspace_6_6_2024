/**
 * 
 */
package com.nse.oder.temporal.orchestrator;

import com.nse.common.config.ApplicationProperties;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:57:47 am
 * <br>Objective: Its objective is to create a WorkflowClient for submitting an order to Temporal Server.
 */
public class WorkflowOrchestratorClient {
	private final ApplicationProperties applicationProperties;

	  public WorkflowOrchestratorClient(ApplicationProperties applicationProperties) {
		this.applicationProperties=applicationProperties;
	}

	public WorkflowClient getWorkflowClient() {
	    var workflowServiceStubsOptions = WorkflowServiceStubsOptions.newBuilder().setTarget(applicationProperties.getTarget()).build();
	    var workflowServiceStubs = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);
	    return WorkflowClient.newInstance(workflowServiceStubs);
	  }
}
