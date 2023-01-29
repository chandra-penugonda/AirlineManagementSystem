package com.app.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.app.service.PaymentService;

@Service
public class CardPayment implements PaymentService {

	private Long cardNo;
	private String cardHolderName;
	private int cc;
	private Date cardExpiryDate;

	@Override
	public boolean pay(double amount) {
		boolean transactionStatus = false;

		// initiateTransaction;
		return transactionStatus;
	}

}
