package com.springpostnight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springpostnight.entity.Fort;

@Repository
public interface FortRepository extends JpaRepository<Fort, Long> {
  
}