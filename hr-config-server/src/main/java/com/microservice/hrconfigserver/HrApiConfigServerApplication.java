package com.microservice.hrconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrApiConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiConfigServerApplication.class, args);
	}

}