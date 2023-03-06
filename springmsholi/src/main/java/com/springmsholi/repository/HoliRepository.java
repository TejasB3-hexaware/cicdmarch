package com.springmsholi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmsholi.entity.Holi;

@Repository
public interface HoliRepository extends JpaRepository<Holi, Long> {
  
}
