package com.microservice.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.services.WorkerService;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private WorkerService service;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> result = this.service.findAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
		Worker result = this.service.findById(id);
		return ResponseEntity.ok(result);
	}
}
