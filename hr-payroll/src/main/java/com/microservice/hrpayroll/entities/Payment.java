package com.microservice.hrpayroll.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {

	private String name;
	private Double dailyIncome;
	private Integer days;

	public double getTotal() {
		return this.dailyIncome * this.days;
	}

}
