package com.jboss.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class PaymentProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// get the id of the input
		PaymentRequest request = exchange.getIn().getBody(PaymentRequest.class);

		// set reply including the id
		PaymentInfo payment = new PaymentInfo();
		payment.setAmount(request.getAmount());
		payment.setMerchantId(request.getMerchantId());
		payment.setMerchantName(request.getMerchantName());
		payment.setPayeeAccountNo(request.getPayeeAccountNo());
		payment.setPayeeName(request.getPayeeFirstName() + " " + request.getPayeeLastName());
		payment.setTransctionId(request.getTransctionId());
		payment.setRequestTimestamp(request.getTransactedTimestamp());
		exchange.getOut().setBody(payment);
		
		System.out.println("here --> body : " + exchange.getOut().getBody());
		
	}
}
