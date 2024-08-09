package com.springproject.springproject.domain.services.Pedido;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Pedido;

public interface PedidoService {

    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    Pedido update(Long id, Pedido pedido);
    void delete(Long id);
    
}