package com.springmscheck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springmscheck.entity.Cricket;
import com.springmscheck.exception.EntityNotFoundException;
import com.springmscheck.repository.CricketRepository;

@Service
public class CricketService {

	@Autowired
	private CricketRepository cricketRepo;

	public Cricket fetchById(final Long id) {
		Optional<Cricket> cricket = cricketRepo.findById(id);
		if (!cricket.isPresent()) {
			throw new EntityNotFoundException("id-" + id);
		}
		return cricket.get();
	}

	public List<Cricket> fetchAll() {
		return cricketRepo.findAll();
	}

	public Cricket create(final Cricket cricket) {
		return cricketRepo.save(cricket);
	}

	public ResponseEntity<Object> update(final Cricket cricket, final Long id) {
		Optional<Cricket> cricketOptional = cricketRepo.findById(id);
		if (!cricketOptional.isPresent()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EntityNotFoundException("id-" + id);
		}
		cricket.setId(id);
		cricketRepo.save(cricket);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	public void delete(final Long id) {
		cricketRepo.deleteById(id);
	}

}
