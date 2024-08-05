package com.springproject.springproject.domain.services.Pago;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Pago;

public interface PagoService {

    List<Pago> findAll();
    Optional<Pago> findById(Long id);
    Pago save(Pago pago);
    Pago update(Long id, Pago pago);
    Optional<Pago> delete(Long id);
    
}
