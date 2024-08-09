package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    @Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.gamaProducto = NULL WHERE p.gamaProducto.gama = :gama")
    void setGamaNull(@Param("gama") String gama);
    
}
