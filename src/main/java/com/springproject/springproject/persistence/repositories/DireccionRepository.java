package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.direccion = NULL WHERE c.direccion.idDireccion = :idDireccion")
    void unsetDireccionClientes(@Param("idDireccion") Long idDireccion);

    @Modifying
    @Transactional
    @Query("DELETE FROM Direccion d WHERE d.idDireccion = :idDireccion")
    void deleteIdDireccion(@Param("idDireccion") Long idDireccion);

}

