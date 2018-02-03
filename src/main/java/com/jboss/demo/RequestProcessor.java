package com.jboss.demo;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

public class RequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// get the id of the input
		PaymentRequest request = exchange.getIn().getBody(PaymentRequest.class);
		
		PaymentInfo payment = new PaymentInfo();
		payment.setAmount(request.getAmount());
		payment.setMerchantId(request.getMerchantId());
		payment.setMerchantName(request.getMerchantName());
		payment.setPayeeAccountNo(request.getPayeeAccountNo());
		payment.setPayeeName(request.getPayeeFirstName() + " " + request.getPayeeLastName());
		payment.setTransctionId(request.getTransctionId());
		payment.setRequestTimestamp(request.getTransactedTimestamp());
		//exchange.getOut().setBody(payment);
		
		Message inMessage = exchange.getIn();
		exchange.getOut().setHeader("Content-Type", "application/json");
		exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "payment");
		exchange.getOut().setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
		exchange.getOut().setBody(payment);
		
		
		/*
		exchange.setPattern(ExchangePattern.InOut);
		Message inMessage = exchange.getIn();
		// set the operation name
		inMessage.setHeader(CxfConstants.OPERATION_NAME, "payment");
		// using the proxy client API
		inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
		
		// creating the request
		MessageContentsList req = new MessageContentsList();
		req.add(payment);
		inMessage.setBody(req);
	    */
	}
}
