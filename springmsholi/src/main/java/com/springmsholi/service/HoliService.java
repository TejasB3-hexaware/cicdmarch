package com.springmsholi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springmsholi.entity.Holi;
import com.springmsholi.exception.EntityNotFoundException;
import com.springmsholi.repository.HoliRepository;

@Service
public class HoliService {

	@Autowired
	private HoliRepository holiRepo;

	public Holi fetchById(final Long id) {
		Optional<Holi> holi = holiRepo.findById(id);
		if (!holi.isPresent()) {
			throw new EntityNotFoundException("id-" + id);
		}
		return holi.get();
	}

	public List<Holi> fetchAll() {
		return holiRepo.findAll();
	}

	public Holi create(final Holi holi) {
		return holiRepo.save(holi);
	}

	public ResponseEntity<Object> update(final Holi holi, final Long id) {
		Optional<Holi> holiOptional = holiRepo.findById(id);
		if (!holiOptional.isPresent()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EntityNotFoundException("id-" + id);
		}
		holi.setId(id);
		holiRepo.save(holi);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	public void delete(final Long id) {
		holiRepo.deleteById(id);
	}

}
