package com.jboss.demo;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GatewayProcessor implements Processor {

	@Override
    public void process(Exchange exchange) throws Exception {
        // get the id of the input
		PaymentRequest payment = exchange.getIn().getBody(PaymentRequest.class);
		PaymentStatus status = new PaymentStatus();
		
		try {
	        String transactionId = payment.getTransctionId();
	        String merchantId = payment.getMerchantId();
	        status.setStatus(PaymentStatus._STATUS_PROCESS);
	        status.setMerchantId(merchantId);
	        status.setTransactionId(transactionId);
	        status.setTimestamp(new Date().getTime());
		}
		catch(Exception e) {
			status.setMerchantId("N/A");
	        status.setTransactionId("N/A");
	        status.setTimestamp(new Date().getTime());
	        status.setError(PaymentStatus._STATUS_ERROR, e.getMessage());
	        //throw e;
		}
		finally {
			exchange.getOut().setBody(status);
		}
        //exchange.getIn().setBody(payment);
    }
}
