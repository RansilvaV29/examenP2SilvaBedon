package espe.edu.ec.sensor_reading.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import espe.edu.ec.sensor_reading.dto.SensorReadingDto;
import espe.edu.ec.sensor_reading.entity.SensorReading;
import espe.edu.ec.sensor_reading.service.SensorReadingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sensor-readings")
public class SensorReadingController {

    @Autowired
    private SensorReadingService service;

    @PostMapping
    public ResponseEntity<SensorReading> createReading(@RequestBody SensorReadingDto dto) {
        SensorReading saved = service.saveReading(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<SensorReading>> getAllReadings() {
        List<SensorReading> readings = service.getAllReadings();
        return ResponseEntity.ok(readings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReadingById(@PathVariable Long id) {
        Optional<SensorReading> reading = service.getReadingById(id);
        return reading.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}