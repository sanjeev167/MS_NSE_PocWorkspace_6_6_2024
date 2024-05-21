/**
 * 
 */
package com.nse.config;

/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:52:20 am
 * <br>Objective:
 */
public class ApplicationProperties {
	  private String target;
	  private String workflowId;
	  private String namespace;
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
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	  
	  
}
