package com.microservice.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import com.microservice.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = this.workerFeignClient.findById(workerId).getBody();
		return Payment.builder().name(worker.getName()).days(days).dailyIncome(worker.getDailyIncome()).build();
	}
}
