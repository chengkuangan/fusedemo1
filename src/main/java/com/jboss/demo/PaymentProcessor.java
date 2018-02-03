package com.jboss.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

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
		// exchange.getOut().setBody(payment);

		try {
			List<Object> providers = new ArrayList<Object>();
			providers.add(new JacksonJsonProvider());
			/*
			WebClient client = WebClient.create("http://localhost:9494/route/payment/mpay", providers);
			client = client.accept("application/json").type("application/json");
			Response r = client.post(payment);
			PaymentStatus resp = r.readEntity(PaymentStatus.class);
			*/
			PaymentStatus resp = new PaymentStatus();
			resp.setStatus(PaymentStatus._STATUS_APPROVED);
			exchange.getOut().setBody(resp);
		} catch (Exception e) {
			PaymentStatus s = new PaymentStatus();
			s.setStatus(PaymentStatus._STATUS_ERROR);
			s.setRejectedReason("Error submitting payment request to Payment Services. Please try again later.");
			exchange.getOut().setBody(s);
		}

	}
}
