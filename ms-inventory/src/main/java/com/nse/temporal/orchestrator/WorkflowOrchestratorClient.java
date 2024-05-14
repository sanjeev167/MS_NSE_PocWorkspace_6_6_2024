/**
 * 
 */
package com.nse.temporal.orchestrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.config.ApplicationProperties;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

/**
 * @author sanjeevkumar 
 * 09-May-2024 
 * 11:26:43 pm
 */
public class WorkflowOrchestratorClient {
	Logger log = LoggerFactory.getLogger(WorkflowOrchestratorClient.class);

	private final ApplicationProperties applicationProperties;

	/**
	 * @param applicationProperties
	 */
	public WorkflowOrchestratorClient(ApplicationProperties applicationProperties) {
		super();
		this.applicationProperties = applicationProperties;
	}

	public WorkflowClient getWorkflowClient() {
		var workflowServiceStubsOptions = WorkflowServiceStubsOptions.newBuilder()
				.setTarget(applicationProperties.getTarget()).build();
		var workflowServiceStubs = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);
		return WorkflowClient.newInstance(workflowServiceStubs);
	}

}// End of WorkflowOrchestratorClient
