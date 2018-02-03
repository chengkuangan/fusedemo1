package com.jboss.demo;

public interface PaymentService {
	public PaymentStatus makePayment(PaymentRequest payment);
}
