package com.jboss.demo.security;

public class ResponseElement {
	private CurrentState currentState;
	private String instanceId;
	private PreviousState previousState;
	
	public CurrentState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public PreviousState getPreviousState() {
		return previousState;
	}
	public void setPreviousState(PreviousState previousState) {
		this.previousState = previousState;
	}
}
