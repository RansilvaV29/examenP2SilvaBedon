package espe.edu.ec.sensor_reading.service;

import java.time.ZonedDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import espe.edu.ec.sensor_reading.dto.SensorAnalizerDto;

@Service
public class AnalisisProducer {
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private ObjectMapper mapper;
	
	public void enviarDatos(String alertaId, String sensorId, String type, Double value, ZonedDateTime timestamp, Double treshold ) {
		try {
			SensorAnalizerDto sensorAnalizerdto = new SensorAnalizerDto(alertaId, sensorId, type, value, timestamp, treshold);
			String json = mapper.writeValueAsString(sensorAnalizerdto);
			template.convertAndSend("analyzer.cola", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
