package com.springproject.springproject.domain.services.Direccion;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Direccion;

public interface DireccionService {

    List<Direccion> findAll();
    Optional<Direccion> findById(Long id);
    Direccion save(Direccion direccion);
    Direccion update(Long id, Direccion direccion);
    Optional<Direccion> delete(Long id);
    
}
