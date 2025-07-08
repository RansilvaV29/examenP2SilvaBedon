package espe.edu.ec.sensor_reading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import espe.edu.ec.sensor_reading.dto.SensorReadingDto;
import espe.edu.ec.sensor_reading.entity.SensorReading;
import espe.edu.ec.sensor_reading.repository.SensorReadingRepository;

@Service
public class SensorReadingService {

    @Autowired
    private SensorReadingRepository repository;
    
    @Autowired
    private AnalisisProducer analisisProducer;

    public SensorReading saveReading(SensorReadingDto dto) {

        SensorReading reading = new SensorReading();
        reading.setSensorId(dto.getSensorId());
        reading.setType(dto.getType());
        reading.setValue(dto.getValue());
        reading.setTimestamp(dto.getTimestamp());
        
        SensorReading saved = repository.save(reading);
        
        analisisProducer.enviarDatos("ALT-" + reading.getId().toString(), reading.getSensorId(), reading.getType(), reading.getValue(), reading.getTimestamp(), 0.0);
        return saved;
    }

    public List<SensorReading> getAllReadings() {
        return repository.findAll();
    }

    public Optional<SensorReading> getReadingById(Long id) {
        return repository.findById(id);
    }

}