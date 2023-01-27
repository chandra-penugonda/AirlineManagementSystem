package com.app.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

	public boolean pay(double amount);
}
