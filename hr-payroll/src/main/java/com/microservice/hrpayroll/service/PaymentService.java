package com.microservice.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return Payment.builder()
				.name("Bob")
				.days(days)
				.dailyIncome(200.0)
				.build();
	}
}
