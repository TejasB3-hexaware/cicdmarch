package com.springthree.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springthree.entity.Building;
import com.springthree.exception.EntityNotFoundException;
import com.springthree.repository.BuildingRepository;

@Service  
public class BuildingService {

  @Autowired
  private BuildingRepository buildingRepo;

  public List<Building> fetchAll() {
    return buildingRepo.findAll();
  }

  public Building fetchById(final Long id) {
    Optional<Building> building = buildingRepo.findById(id);

		if (!building.isPresent()){
			throw new EntityNotFoundException("id-" + id);
    }
		return building.get();
  }

  public void delete(final Long id) {
    buildingRepo.deleteById(id);
  }

  public Building create(final Building building) {
    return buildingRepo.save(building);
  }

  public ResponseEntity<Object> update(final Building building, final Long id) {
    Optional<Building> buildingOptional = buildingRepo.findById(id);
		if (!buildingOptional.isPresent()) {
			return ResponseEntity.notFound().build();
    }
		building.setId(id);
		buildingRepo.save(building);
		return ResponseEntity.noContent().build();
  }

}
