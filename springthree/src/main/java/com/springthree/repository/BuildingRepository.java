package com.springthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springthree.entity.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
  
}