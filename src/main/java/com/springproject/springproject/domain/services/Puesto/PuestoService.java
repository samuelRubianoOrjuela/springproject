package com.springproject.springproject.domain.services.Puesto;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Puesto;

public interface PuestoService {

    List<Puesto> findAll();
    Optional<Puesto> findById(Long id);
    Puesto save(Puesto puesto);
    Puesto update(Long id, Puesto puesto);
    Optional<Puesto> delete(Long id);
    
}
