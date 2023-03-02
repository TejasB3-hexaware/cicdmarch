package com.springpostnight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springpostnight.entity.Fort;
import com.springpostnight.service.FortService;

@RestController
public class FortController {

	@Autowired
	private FortService fortService;

	@GetMapping("/fort")
	public List<Fort> fetchAll() {
		return this.fortService.fetchAll();
	}

	@GetMapping("/fort/{id}")
	public Fort fetchById(@PathVariable Long id) {
		return this.fortService.fetchById(id);
	}

	@DeleteMapping("/fort/{id}")
	public void delete(@PathVariable Long id) {
		this.fortService.delete(id);
	}

	@PostMapping("/fort")
	public Fort create(@RequestBody Fort fort) {
		return this.fortService.create(fort);
	}
	
	@PutMapping("/fort/{id}")
	public ResponseEntity<Object> update(@RequestBody Fort fort, @PathVariable Long id) {
		return this.fortService.update(fort, id);
	}
}