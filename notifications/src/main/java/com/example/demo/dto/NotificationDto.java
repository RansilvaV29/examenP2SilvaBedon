package com.example.demo.dto;

import java.time.ZonedDateTime;

public class NotificationDto {
	private String notificationId;
	private String eventType;
	private String recipient;
	private String status;
    private ZonedDateTime timestamp;
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public NotificationDto(String notificationId, String eventType, String recipient, String status,
			ZonedDateTime timestamp) {
		super();
		this.notificationId = notificationId;
		this.eventType = eventType;
		this.recipient = recipient;
		this.status = status;
		this.timestamp = timestamp;
	}
    
    
}
