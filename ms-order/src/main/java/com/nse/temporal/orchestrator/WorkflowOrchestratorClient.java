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
	    //Programmatically we can register a name space of our choice at Temporal Server
	   
	    /**RegisterNamespaceRequest request =
	    	    RegisterNamespaceRequest.newBuilder()
	    	        .setNamespace(applicationProperties.getNamespace())
	    	        .setWorkflowExecutionRetentionPeriod(Durations.fromDays(7))
	    	        .build();
	    workflowServiceStubs.blockingStub().registerNamespace(request);
	    **/
	    
	    //Set the name space for this workflow. Not using set name space. Going in default workspace
	   // Builder builder = DescribeNamespaceRequest.newBuilder().setNamespace(applicationProperties.getNamespace());	     
	    //workflowServiceStubs.blockingStub().describeNamespace(builder.build());
	    
	    return WorkflowClient.newInstance(workflowServiceStubs);
	  }
}
