/**
 * 
 */
package com.nse.config;

/**
 * @author sanjeevkumar
 * 09-May-2024
 * 11:18:22 pm
 */
public class ApplicationProperties {

	private String target;
	private String workflowId;
	private String workflowTaskQueue;
	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * @return the workflowId
	 */
	public String getWorkflowId() {
		return workflowId;
	}
	/**
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	/**
	 * @return the workflowTaskQueue
	 */
	public String getWorkflowTaskQueue() {
		return workflowTaskQueue;
	}
	/**
	 * @param workflowTaskQueue the workflowTaskQueue to set
	 */
	public void setWorkflowTaskQueue(String workflowTaskQueue) {
		this.workflowTaskQueue = workflowTaskQueue;
	}
	
	
	
	  
}//End of ApplicationProperties 
