package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
