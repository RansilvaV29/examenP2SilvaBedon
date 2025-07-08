package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Notification;
import com.example.demo.service.Notificacionservice;

@RestController
@RequestMapping("/notificaciones")
public class NotificationController {

	@Autowired
	private Notificacionservice notificacionservice;
	
	@GetMapping
	public ResponseEntity<List<Notification>> obtenerTodos() {
        return ResponseEntity.ok(notificacionservice.obtenerTodos());
    }
}
