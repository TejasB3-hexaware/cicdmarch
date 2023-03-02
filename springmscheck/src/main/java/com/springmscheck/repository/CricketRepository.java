package com.springmscheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmscheck.entity.Cricket;

@Repository
public interface CricketRepository extends JpaRepository<Cricket, Long> {
  
}
