package com.springproject.springproject.domain.services.EstadoPedido;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.EstadoPedido;

public interface EstadoPedidoService {

    List<EstadoPedido> findAll();
    Optional<EstadoPedido> findById(Long id);
    EstadoPedido save(EstadoPedido estadoPedido);
    EstadoPedido update(Long id, EstadoPedido estadoPedido);
    Optional<EstadoPedido> delete(Long id);
    
}
