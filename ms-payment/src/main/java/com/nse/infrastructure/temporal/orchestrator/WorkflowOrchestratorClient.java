/**
 * 
 */
package com.nse.infrastructure.temporal.orchestrator;

import com.nse.config.ApplicationProperties;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 9:48:07 pm
 */

public class WorkflowOrchestratorClient {
	private final ApplicationProperties applicationProperties;

	  /**
	 * @param applicationProperties
	 */
	public WorkflowOrchestratorClient(ApplicationProperties applicationProperties) {
		super();
		this.applicationProperties = applicationProperties;
	}

	public WorkflowClient getWorkflowClient() {
	    var workflowServiceStubsOptions =
	        WorkflowServiceStubsOptions.newBuilder()
	            .setTarget(applicationProperties.getTarget())
	            .build();
	    var workflowServiceStubs = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);
	    return WorkflowClient.newInstance(workflowServiceStubs);
	  }
}
