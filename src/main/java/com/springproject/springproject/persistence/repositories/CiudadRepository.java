package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}
