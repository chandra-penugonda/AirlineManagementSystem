package com.app.service.impl;

import java.time.LocalDateTime;

import com.app.service.NotificationService;

public class EmailNotification extends NotificationService {

	private String senderId;
	private String recipientId;

	public EmailNotification(String senderId, String recipientId, int notificatonId, LocalDateTime notificationDateTime,
			String notificationContent) {
		super(notificatonId, notificationDateTime, notificationContent);
		this.senderId = senderId;
		this.recipientId = recipientId;
	}

	@Override
	public boolean sendNotification() {
		boolean notificationStatus = false;

		// initiateNotification;

		return notificationStatus;
	}

}
