from locust import HttpUser, task, between
import random
from datetime import datetime

class MyUser(HttpUser):
    host = "http://192.168.100.28:8000/api/conjunta/p2"
    wait_time = between(0.5, 1.5)

    @task
    def enviar_dato_sensor(self):
        payload = {
            "sensorId": "SENSOR_01",
            "type": "temperature",
            "value": random.randint(1,60),
            "timestamp": datetime.utcnow().isoformat() + "Z"  # Fecha dinámica
        }

        self.client.post("/sensor-readings", json=payload)

