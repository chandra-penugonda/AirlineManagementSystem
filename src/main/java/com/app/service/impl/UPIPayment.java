package com.app.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.service.PaymentService;

@Service
public class UPIPayment implements PaymentService {

	private String upiId;
	private String upiName;
	private LocalDateTime transactionTimestamp;

	@Override
	public boolean pay(double amount) {
		boolean transactionStatus = false;

		// initiateTransaction
		return transactionStatus;
	}

}
