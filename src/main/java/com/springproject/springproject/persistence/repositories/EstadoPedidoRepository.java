package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springproject.springproject.persistence.entities.EstadoPedido;

public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Long>{

    @Modifying
    @Query("UPDATE Pedido p SET p.estadoPedido = NULL WHERE p.estadoPedido.idEstado = ?1")
    void setEstadoNull(Long idEstado);

}
