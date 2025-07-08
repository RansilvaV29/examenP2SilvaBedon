package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfiguration {
	
	@Bean
	public Queue catalogoCola() {
		return new Queue("analyzer.cola", false);
	}
}

