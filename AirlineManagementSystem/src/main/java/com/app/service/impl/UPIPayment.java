package com.app.service.impl;

import java.time.LocalDateTime;

import com.app.service.PaymentService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UPIPayment implements PaymentService {

	private String upiId;
	private String upiName;
	private LocalDateTime transactionTimestamp;

	@Override
	public boolean pay(double amount) {
		boolean transactionStatus = false;

		//initiateTransaction
		return transactionStatus;
	}

}
