package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE DetallePedido d SET d.producto = NULL WHERE d.producto.idProducto = :idProducto")
    void setProductoNull(@Param("idProducto") Long idProducto);
    
}
