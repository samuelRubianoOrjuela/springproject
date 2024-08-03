package com.springproject.springproject.domain.services.Ciudad;

import java.util.List;
import java.util.Optional;
import com.springproject.springproject.persistence.entities.Ciudad;

public interface CiudadService {

    List<Ciudad> findAll();
    Optional<Ciudad> findById(Long id);
    Ciudad save(Ciudad ciudad);
    Ciudad update(Long id, Ciudad ciudad);
    Optional<Ciudad> delete(Long id);
    
}
