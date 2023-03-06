package com.springmsholi.controller;

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

import com.springmsholi.entity.Holi;
import com.springmsholi.service.HoliService;

@RestController
public class HoliController {

	@Autowired
	private HoliService holiService;

	@GetMapping("/holi")
	public List<Holi> fetchAll() {
		return this.holiService.fetchAll();
	}

	@GetMapping("/holi/{id}")
	public Holi fetchById(@PathVariable Long id) {
		return this.holiService.fetchById(id);
	}

	@DeleteMapping("/holi/{id}")
	public void delete(@PathVariable Long id) {
		this.holiService.delete(id);
	}

	@PostMapping("/holi")
	public Holi create(@RequestBody Holi holi) {
		return this.holiService.create(holi);
	}
	
	@PutMapping("/holi/{id}")
	public ResponseEntity<Object> update(@RequestBody Holi holi, @PathVariable Long id) {
		return this.holiService.update(holi, id);
	}
}