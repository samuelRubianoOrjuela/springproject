package com.springproject.springproject.domain.services.Oficina;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Oficina;

public interface OficinaService {

    List<Oficina> findAll();
    Optional<Oficina> findById(Long id);
    Oficina save(Oficina oficina);
    Oficina update(Long id, Oficina oficina);
    Optional<Oficina> delete(Long id);
    
}
