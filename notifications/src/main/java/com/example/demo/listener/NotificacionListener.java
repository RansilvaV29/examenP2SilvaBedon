package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.NotificationDto;
import com.example.demo.service.Notificacionservice;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NotificacionListener {
	
	@Autowired
	private Notificacionservice notificacionService;
	
	@Autowired
	private ObjectMapper mapped;
	
	@RabbitListener(queues = "notificacion2.cola")
	public void recibirNotificacion(String mensajeJson) {
		try {
			NotificationDto dto = mapped.readValue(mensajeJson, NotificationDto.class);
			notificacionService.guardarNotificacion(dto);
			System.out.println("Notificacion recibida y guardada ");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

