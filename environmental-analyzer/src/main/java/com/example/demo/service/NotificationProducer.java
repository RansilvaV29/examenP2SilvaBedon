package com.example.demo.service;

import java.time.ZonedDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationProducer {

	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	public void enviarNotificacion(String notificacionId , String eventType, String recipient, String status, ZonedDateTime timestamp ) {
		try {
			NotificationDto sensorAnalizerdto = new NotificationDto(notificacionId, eventType, recipient, status, timestamp);
			String json = mapper.writeValueAsString(sensorAnalizerdto);
			template.convertAndSend("notificacion2.cola", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

