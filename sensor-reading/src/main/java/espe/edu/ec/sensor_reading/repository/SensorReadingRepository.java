package espe.edu.ec.sensor_reading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import espe.edu.ec.sensor_reading.entity.SensorReading;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
}