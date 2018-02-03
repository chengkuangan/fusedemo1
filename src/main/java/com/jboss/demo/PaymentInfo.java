package com.jboss.demo;

import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PaymentInfo {
	
	private long requestTimestamp;
	private String transctionId;
	private String payeeName;
	private String payeeAccountNo;
	private double amount;
	private String merchantId;
	private String merchantName;
	
	@JsonIgnore
	public String getRequestDate() {
		if (requestTimestamp > 0l) {
			return new Date(requestTimestamp).toString();
		} else {
			return "Invalid Timestamp.";
		}
	}

	public long getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(long requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public String getTransctionId() {
		return transctionId;
	}

	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	public void setError(String status, String message){
		// do nothing
	}
	
}
