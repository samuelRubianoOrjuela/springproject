package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
