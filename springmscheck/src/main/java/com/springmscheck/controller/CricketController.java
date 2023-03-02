package com.springmscheck.controller;

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

import com.springmscheck.entity.Cricket;
import com.springmscheck.service.CricketService;

@RestController
public class CricketController {

	@Autowired
	private CricketService cricketService;

	@GetMapping("/cricket")
	public List<Cricket> fetchAll() {
		return this.cricketService.fetchAll();
	}

	@GetMapping("/cricket/{id}")
	public Cricket fetchById(@PathVariable Long id) {
		return this.cricketService.fetchById(id);
	}

	@DeleteMapping("/cricket/{id}")
	public void delete(@PathVariable Long id) {
		this.cricketService.delete(id);
	}

	@PostMapping("/cricket")
	public Cricket create(@RequestBody Cricket cricket) {
		return this.cricketService.create(cricket);
	}
	
	@PutMapping("/cricket/{id}")
	public ResponseEntity<Object> update(@RequestBody Cricket cricket, @PathVariable Long id) {
		return this.cricketService.update(cricket, id);
	}
}