/**
 * 
 */
package com.nse.temporal.orchestrator;
import com.nse.config.ApplicationProperties;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 10:41:50 pm
 */
public class WorkflowOrchestratorClient {
	 private final ApplicationProperties applicationProperties;

	  /**
	 * @param applicationProperties
	 */
	public WorkflowOrchestratorClient(ApplicationProperties applicationProperties) {
		this.applicationProperties=applicationProperties;
	}

	public WorkflowClient getWorkflowClient() {
		WorkflowServiceStubsOptions workflowServiceStubsOptions =
	        WorkflowServiceStubsOptions.newBuilder()
	            .setTarget(applicationProperties.getTarget())
	            .build();
	    WorkflowServiceStubs workflowServiceStubs = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);
	    return WorkflowClient.newInstance(workflowServiceStubs);
	  }
}
