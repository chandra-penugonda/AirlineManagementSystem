package com.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

	public <T, V> boolean sendNotification(T sender, V reciever, String notificationId, LocalDateTime notificationTimestamp,
			String notificationContext);
}
