package com.jboss.demo.security;

public class Record {
	
	private String awsRegion;
	private String eventName;
	private String eventSource;
	private String eventTime;
	private String eventVersion;
	private RequestParameters requestParameters;
	private ResponseElements responseElements;
	private String sourceIPAddress;
	private String userAgent;
	private UserIdentity userIdentity;
	
	public String getAwsRegion() {
		return awsRegion;
	}
	public void setAwsRegion(String awsRegion) {
		this.awsRegion = awsRegion;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventSource() {
		return eventSource;
	}
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventVersion() {
		return eventVersion;
	}
	public void setEventVersion(String eventVersion) {
		this.eventVersion = eventVersion;
	}
	public RequestParameters getRequestParameters() {
		return requestParameters;
	}
	public void setRequestParameters(RequestParameters requestParameters) {
		this.requestParameters = requestParameters;
	}
	public ResponseElements getResponseElements() {
		return responseElements;
	}
	public void setResponseElements(ResponseElements responseElements) {
		this.responseElements = responseElements;
	}
	public String getSourceIPAddress() {
		return sourceIPAddress;
	}
	public void setSourceIPAddress(String sourceIPAddress) {
		this.sourceIPAddress = sourceIPAddress;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public UserIdentity getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(UserIdentity userIdentity) {
		this.userIdentity = userIdentity;
	}

}
