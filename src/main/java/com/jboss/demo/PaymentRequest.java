package com.jboss.demo;

import java.io.Serializable;
import java.util.Date;


public class PaymentRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6770811711353837489L;
	protected long transactedTimestamp;
	protected String transctionId;
	private String payeeFirstName;
	private String payeeLastName;
	protected String payeeAccountNo;
	protected double amount;
	private String merchantId;
	private String merchantName;
	
	public String getTransactedDate() {
		if (transactedTimestamp > 0l) {
			return new Date(transactedTimestamp).toString();
		} else {
			return "Invalid Timestamp.";
		}
	}

	public long getTransactedTimestamp() {
		return transactedTimestamp;
	}

	public void setTransactedTimestamp(long transactedTimestamp) {
		this.transactedTimestamp = transactedTimestamp;
	}

	public String getTransctionId() {
		return transctionId;
	}

	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
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

	public String getPayeeFirstName() {
		return payeeFirstName;
	}

	public void setPayeeFirstName(String payeeFirstName) {
		this.payeeFirstName = payeeFirstName;
	}

	public String getPayeeLastName() {
		return payeeLastName;
	}

	public void setPayeeLastName(String payeeLastName) {
		this.payeeLastName = payeeLastName;
	}
	
	public PaymentRequest deepClone() {
		PaymentRequest clone = new PaymentRequest();
        clone.setAmount(this.amount);
        clone.setMerchantId(merchantId);
        clone.setMerchantName(merchantName);
        clone.setPayeeAccountNo(payeeAccountNo);
        clone.setPayeeFirstName(payeeFirstName);
        clone.setPayeeLastName(payeeLastName);
        clone.setTransactedTimestamp(transactedTimestamp);
        clone.setTransctionId(transctionId);
        return clone;
    }


}
