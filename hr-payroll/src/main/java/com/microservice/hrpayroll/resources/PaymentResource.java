package com.microservice.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getPaymentFallBack")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId,
			@PathVariable("days") Integer days) {

		Payment payment = this.paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);

	}

	public ResponseEntity<Payment> getPaymentFallBack(Long workerId, Integer days) {
		Payment payment = Payment.builder().dailyIncome(30.0).days(days).name("Tiago").build();
		return ResponseEntity.ok(payment);

	}

}
