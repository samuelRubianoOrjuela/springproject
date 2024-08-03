package com.springproject.springproject.domain.services.FormaPago;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.FormaPago;

public interface FormaPagoService {

    List<FormaPago> findAll();
    Optional<FormaPago> findById(Long id);
    FormaPago save(FormaPago formaPago);
    FormaPago update(Long id, FormaPago formaPago);
    Optional<FormaPago> delete(Long id);
    
}
