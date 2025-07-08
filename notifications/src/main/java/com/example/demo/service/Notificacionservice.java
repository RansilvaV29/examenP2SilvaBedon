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
		//notificacion.setEventType(dto.getEventType());
		notificacion.setRecipient(dto.getRecipient());
		//notificacion.setStatus(dto.getStatus());
		notificacion.setTimestamp(dto.getTimestamp());
		
		String tipoOriginal = dto.getEventType();
		switch (tipoOriginal) {
		case "HighTemperatureAlert": {
			
			notificacion.setEventType("alerta de temperatura alta");
			notificacion.setStatus("CRITICAL");
			break;
		}
		case "temperatureNormal": {
			
			notificacion.setEventType("monitoreo de temperatura normal");
			notificacion.setStatus("NORMAL");
			break;
		}
		case "LowHumidityAlert": {
			
			notificacion.setEventType("alerta de humedad baja");
			notificacion.setStatus("CRITICAL");			
			break;
		}
		case "normalHumidity": {
			
			notificacion.setEventType("monitoreo de humedad normal");
			notificacion.setStatus("NORMAL");

			break;
		}
		case "SeismicActivityAlert": {
			
			notificacion.setEventType("alerta de sismo");
			notificacion.setStatus("CRITICAL");

			break;
		}
		case "normalSeismic": {
			
			notificacion.setEventType("monitoreo de movimiento tectonico normal");
			notificacion.setStatus("NORMAL");

			break;
		}
		default:
			notificacion.setEventType(dto.getEventType()); // No se detecta alerta
		    notificacion.setStatus("PENDING"); // o cualquier valor por defecto válido
			break;		
		}

		
		

		notificacionRepository.save(notificacion);
		System.out.println("Guardando notificación: " + notificacion.getNotificationId());

	}
	
	public List<Notification> obtenerTodos(){
		return notificacionRepository.findAll();
	}
}
