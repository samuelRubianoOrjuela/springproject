package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Pedido p SET p.cliente = NULL WHERE p.cliente.idCliente = :id")
    void setClienteNullPedido(Long id);

}
