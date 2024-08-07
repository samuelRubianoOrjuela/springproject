package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.springproject.persistence.entities.Dimensiones;

@Repository
public interface DimensionesRepository extends JpaRepository<Dimensiones, Long> {

}
