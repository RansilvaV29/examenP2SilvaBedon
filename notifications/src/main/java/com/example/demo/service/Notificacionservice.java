package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationDto;
import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificacionRepository;

@Service
public class Notificacionservice {
	@Autowired
	private NotificacionRepository notificacionRepository;
	
	
	public void guardarNotificacion(NotificationDto dto) {
		Notification notificacion = new Notification();
		notificacion.setNotificationId(dto.getNotificationId());
		notificacion.setEventType(dto.getEventType());
		notificacion.setRecipient(dto.getRecipient());
		notificacion.setStatus(dto.getStatus());
		notificacion.setTimestamp(dto.getTimestamp());

		notificacionRepository.save(notificacion);
		System.out.println("Guardando notificación: " + notificacion.getNotificationId());

	}
	
	public List<Notification> obtenerTodos(){
		return notificacionRepository.findAll();
	}
}
