package com.app.service.impl;

import java.util.Date;

import com.app.service.PaymentService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardPayment implements PaymentService {

	private Long cardNo;
	private String cardHolderName;
	private int cc;
	private Date cardExpiryDate;
	
	@Override
	public boolean pay(double amount) {
		boolean transactionStatus = false;

		//initiateTransaction;
		return transactionStatus;
	}

}
