package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SensorAnalizerDto;
import com.example.demo.service.SensorAnalizerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SensorAnalizerListener {
	@Autowired
	private SensorAnalizerService analizerService;
	
	@Autowired
	private ObjectMapper mapper;
	
	@RabbitListener(queues = "analyzer.cola")
	public void recibirDatos(String mensajeJson) {
		try {
			SensorAnalizerDto dto = mapper.readValue(mensajeJson, SensorAnalizerDto.class);
			analizerService.ejecutarAnalisis(dto);
			System.out.println("Analsiis recibido ");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
