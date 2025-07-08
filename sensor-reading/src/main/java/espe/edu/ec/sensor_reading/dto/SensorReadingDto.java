package espe.edu.ec.sensor_reading.dto;

import java.time.ZonedDateTime;

public class SensorReadingDto {
    private String sensorId;
    private String type;
    private Double value;
    private ZonedDateTime timestamp;

    // Getters y setters

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}