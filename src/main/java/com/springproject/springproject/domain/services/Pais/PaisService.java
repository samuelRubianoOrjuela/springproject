package com.springproject.springproject.domain.services.Pais;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Pais;

public interface PaisService {

    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais pais);
    Pais update(Long id, Pais pais);
    Optional<Pais> delete(Long id);
    
}
