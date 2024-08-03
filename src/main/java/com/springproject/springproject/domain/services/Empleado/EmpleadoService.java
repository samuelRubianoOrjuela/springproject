package com.springproject.springproject.domain.services.Empleado;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Empleado;

public interface EmpleadoService {

    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    Empleado save(Empleado empleado);
    Empleado update(Long id, Empleado empleado);
    Optional<Empleado> delete(Long id);
    
}
