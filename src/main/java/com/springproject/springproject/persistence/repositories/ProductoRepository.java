package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
