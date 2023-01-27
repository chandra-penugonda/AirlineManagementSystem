package com.app.service;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NotificationService {

	private int notificatonId;
	private LocalDateTime notificationDateTime;
	private String notificationContent;

	public abstract boolean sendNotification();
}
