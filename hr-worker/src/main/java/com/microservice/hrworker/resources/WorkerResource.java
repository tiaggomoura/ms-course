package com.microservice.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService service;

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
