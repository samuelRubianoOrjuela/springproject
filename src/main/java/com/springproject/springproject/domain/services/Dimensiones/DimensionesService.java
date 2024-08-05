package com.springproject.springproject.domain.services.Dimensiones;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Dimensiones;

public interface DimensionesService {

    List<Dimensiones> findAll();
    Optional<Dimensiones> findById(Long id);
    Dimensiones save(Dimensiones dimensiones);
    Dimensiones update(Long id, Dimensiones dimensiones);
    Optional<Dimensiones> delete(Long id);
    
}
