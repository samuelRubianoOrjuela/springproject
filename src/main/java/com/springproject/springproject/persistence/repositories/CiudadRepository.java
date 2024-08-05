package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springproject.springproject.persistence.entities.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

}
