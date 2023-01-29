package com.app.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.service.NotificationService;

@Service
public class SmsNotification implements NotificationService {

	@Override
	public <T, V> boolean sendNotification(T sender, V reciever, String notificationId,
			LocalDateTime notificationTimestamp, String notificationContext) {
		// TODO Auto-generated method stub
		return false;
	}

}
