package com.example.demo;

import feign.micrometer.MicrometerObservationCapability;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@EnableFeignClients(clients = ExternalService.class)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Order(1000)
	FeignLoggingCapability feignLoggingCapability() {
		return new FeignLoggingCapability();
	}

	@Bean
	@Order(100)
	MicrometerObservationCapability micrometerObservationCapability(ObservationRegistry registry) {
		return new MicrometerObservationCapability(registry);
	}
}
