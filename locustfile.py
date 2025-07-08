from locust import HttpUser, task, between
import json
from datetime import datetime

class SensorUser(HttpUser):
    wait_time = between(1, 3)  # Espera entre peticiones para simular usuarios reales

    @task
    def enviar_dato_sensor(self):
        payload = {
            "sensorId": "SENSOR_01",
            "type": "temperature",
            "value": 20,
            "timestamp": datetime.utcnow().isoformat() + "Z"  # Fecha dinámica
        }

        headers = {"Content-Type": "application/json"}
        self.client.post("/sensor-readings", data=json.dumps(payload), headers=headers)
