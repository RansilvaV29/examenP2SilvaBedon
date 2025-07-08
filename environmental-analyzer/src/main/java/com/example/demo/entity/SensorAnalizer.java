package com.example.demo.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor_analizer")
public class SensorAnalizer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "alert_id", nullable = false)
	private String alertaId;
	
	@Column(name = "sensor_id", nullable = false)
    private String sensorId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "timestamp", nullable = false)
    private ZonedDateTime timestamp;
    
    @Column(name = "treshold", nullable = false)
    private Double treshold;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
