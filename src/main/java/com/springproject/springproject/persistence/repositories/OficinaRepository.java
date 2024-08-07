package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Empleado e SET e.oficina = NULL WHERE e.oficina.idOficina = :id")
    void setEmpleadoNull(Long id);
}
