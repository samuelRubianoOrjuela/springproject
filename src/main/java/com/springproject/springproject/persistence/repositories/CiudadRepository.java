package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springproject.springproject.persistence.entities.Ciudad;

import jakarta.transaction.Transactional;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Ciudad c SET c.pais = NULL WHERE c.pais.idPais = :idPais")
    void setPaisToNullById(@Param("idPais") Long idPais);
}
