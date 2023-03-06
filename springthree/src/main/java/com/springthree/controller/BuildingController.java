package com.springthree.controller;

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

import com.springthree.entity.Building;
import com.springthree.service.BuildingService;

@RestController
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("/building")
	public List<Building> fetchAll() {
		return this.buildingService.fetchAll();
	}

	@GetMapping("/building/{id}")
	public Building fetchById(@PathVariable Long id) {
		return this.buildingService.fetchById(id);
	}

	@DeleteMapping("/building/{id}")
	public void delete(@PathVariable Long id) {
		this.buildingService.delete(id);
	}

	@PostMapping("/building")
	public Building create(@RequestBody Building building) {
		return this.buildingService.create(building);
	}
	
	@PutMapping("/building/{id}")
	public ResponseEntity<Object> update(@RequestBody Building building, @PathVariable Long id) {
		return this.buildingService.update(building, id);
	}
}