package com.springpostnight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springpostnight.entity.Fort;
import com.springpostnight.exception.EntityNotFoundException;
import com.springpostnight.repository.FortRepository;

@Service  
public class FortService {

  @Autowired
  private FortRepository fortRepo;

  public List<Fort> fetchAll() {
    return fortRepo.findAll();
  }

  public Fort fetchById(final Long id) {
    Optional<Fort> fort = fortRepo.findById(id);

		if (!fort.isPresent()){
			throw new EntityNotFoundException("id-" + id);
    }
		return fort.get();
  }

  public void delete(final Long id) {
    fortRepo.deleteById(id);
  }

  public Fort create(final Fort fort) {
    return fortRepo.save(fort);
  }

  public ResponseEntity<Object> update(final Fort fort, final Long id) {
    Optional<Fort> fortOptional = fortRepo.findById(id);
		if (!fortOptional.isPresent()) {
			return ResponseEntity.notFound().build();
    }
		fort.setId(id);
		fortRepo.save(fort);
		return ResponseEntity.noContent().build();
  }

}
