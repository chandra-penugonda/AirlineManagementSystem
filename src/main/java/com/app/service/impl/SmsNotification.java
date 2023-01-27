package com.app.service.impl;

import java.time.LocalDateTime;

import com.app.service.NotificationService;

public class SmsNotification extends NotificationService {

	private int mobileNo;

	public SmsNotification(int mobileNo, int notificatonId, LocalDateTime notificationDateTime,
			String notificationContent) {
		super(notificatonId, notificationDateTime, notificationContent);
		this.mobileNo = mobileNo;
	}

	@Override
	public boolean sendNotification() {
		boolean notificationStatus = false;

		// initiateNotification;
		return notificationStatus;
	}

}
