package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.empleadoRepVentas = NULL WHERE c.empleadoRepVentas.idEmpleado = :id")
    void setEmpleadoNull(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Empleado e SET e.jefe = NULL WHERE e.jefe.idEmpleado = :id")
    void setJefeNull(Long id);
}
