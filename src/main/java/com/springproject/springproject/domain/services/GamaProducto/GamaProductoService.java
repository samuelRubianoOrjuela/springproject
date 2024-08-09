package com.springproject.springproject.domain.services.GamaProducto;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.GamaProducto;

public interface GamaProductoService {

    List<GamaProducto> findAll();
    Optional<GamaProducto> findById(String gama);
    GamaProducto save(GamaProducto gamaProducto);
    GamaProducto update(String id, GamaProducto gamaProducto);
    Optional<GamaProducto> delete(String id);
    
}
