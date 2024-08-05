package com.springproject.springproject.domain.services.Proveedor;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Proveedor;

public interface ProveedorService {

    List<Proveedor> findAll();
    Optional<Proveedor> findById(Long id);
    Proveedor save(Proveedor proveedor);
    Proveedor update(Long id, Proveedor proveedor);
    Optional<Proveedor> delete(Long id);
    
}
