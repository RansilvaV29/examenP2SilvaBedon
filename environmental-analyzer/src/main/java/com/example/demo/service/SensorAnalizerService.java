package com.example.demo.service;

import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SensorAnalizerDto;
import com.example.demo.entity.SensorAnalizer;
import com.example.demo.repository.SensorAnalizerRepository;

@Service
public class SensorAnalizerService {

	@Autowired
	private SensorAnalizerRepository analizerRepository;

	@Autowired
	private NotificationProducer notificationProducer;
	public List<SensorAnalizer> obtenerTodos() {
		return analizerRepository.findAll();
	}

	public Optional<SensorAnalizer> obtenerPorId(Long id) {
		return analizerRepository.findById(id);
	}

	private static final Map<String, Double> THRESHOLDS = Map.of("temperature", 40.0, "humidity", 20.0, "seismic", 3.0);

	public void ejecutarAnalisis(SensorAnalizerDto dto) {
		SensorAnalizer analizer = new SensorAnalizer();
		analizer.setAlertaId(dto.getAlertaId());
		analizer.setSensorId(dto.getSensorId());
		analizer.setValue(dto.getValue());
		analizer.setTimestamp(dto.getTimestamp());

		String tipoOriginal = dto.getType().toLowerCase();
		double valor = dto.getValue();
		double threshold = THRESHOLDS.getOrDefault(tipoOriginal, 0.0);

		analizer.setTreshold(threshold);
		switch (tipoOriginal) {
		case "temperature":
			analizer.setType(valor > threshold ? "HighTemperatureAlert" : "temperatureNormal");
			break;

		case "humidity":
			analizer.setType(valor < threshold ? "LowHumidityAlert" : "normalHumidity");
			break;

		case "seismic":
			analizer.setType(valor > threshold ? "SeismicActivityAlert" : "normalSeismic");
			break;

		default:
			analizer.setType(dto.getType()); // No se detecta alerta
			break;
		}

		analizerRepository.save(analizer);
		
		notificationProducer.enviarNotificacion("NOT-"+ analizer.getId().toString(), analizer.getType(), "Administradores", "", analizer.getTimestamp());

		// return new ResponseDto("Datos recibidos y analizados", analizer);
	}
}
