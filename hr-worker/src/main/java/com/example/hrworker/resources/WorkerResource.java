package com.example.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import com.sun.istack.logging.Logger;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = Logger.getLogger(WorkerResource.class);
	private static Long qtd = 1L;
	
	@Value("${eureka.instance.instance-id}")
	public String server;

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		logger.info(server + " QTD" + qtd++);
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		logger.info(server + " QTD" + qtd++);
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}

}
