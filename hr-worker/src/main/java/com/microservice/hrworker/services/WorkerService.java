package com.microservice.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public Worker findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Worker> findAll() {
		return this.repository.findAll();
	}

}
