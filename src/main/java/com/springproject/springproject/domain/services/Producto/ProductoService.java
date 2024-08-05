package com.springproject.springproject.domain.services.Producto;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Producto;

public interface ProductoService {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id, Producto producto);
    Optional<Producto> delete(Long id);
    
}
