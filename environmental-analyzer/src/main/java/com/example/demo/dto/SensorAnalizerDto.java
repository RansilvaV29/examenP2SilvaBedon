package com.example.demo.dto;

import java.time.ZonedDateTime;

public class SensorAnalizerDto {
	private String alertaId;
    private String sensorId;
    private String type;
    private Double value;
    private ZonedDateTime timestamp;
    private Double treshold;
	public String getAlertaId() {
		return alertaId;
	}
	public void setAlertaId(String alertaId) {
		this.alertaId = alertaId;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Double getTreshold() {
		return treshold;
	}
	public void setTreshold(Double treshold) {
		this.treshold = treshold;
	}

}
