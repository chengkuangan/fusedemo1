package com.jboss.demo;

import java.text.SimpleDateFormat;

public class PaymentStatus{
	
	private String status;
	private String merchantId;
	private String transactionId;
	private long timestamp;
	private String rejectedReason;
	final public static String _STATUS_PROCESS = "Processing";
	final public static String _STATUS_APPROVED = "Approved";
	final public static String _STATUS_REJECTED = "Rejected";
	final public static String _STATUS_ERROR = "Error";
	
	
	public String getRejectedReason() {
		return rejectedReason;
	}
	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public void setError(String status, String message){
		this.status = status;
		this.rejectedReason = message;
	}
}
