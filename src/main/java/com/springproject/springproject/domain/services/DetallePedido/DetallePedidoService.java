package com.springproject.springproject.domain.services.DetallePedido;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.DetallePedido;

public interface DetallePedidoService {

    List<DetallePedido> findAll();
    Optional<DetallePedido> findById(Long id);
    DetallePedido save(DetallePedido detallePedido);
    DetallePedido update(Long id, DetallePedido detallePedido);
    Optional<DetallePedido> delete(Long id);
    
}
