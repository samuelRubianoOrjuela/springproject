package com.springproject.springproject.domain.services.Pedido;

import com.springproject.springproject.persistence.entities.Pedido;
import com.springproject.springproject.persistence.repositories.DetallePedidoRepository;
import com.springproject.springproject.persistence.repositories.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido no existe con id " + id );
        }
        pedido.setIdPedido(id); 
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido no existe con id " + id);
        }
        detallePedidoRepository.setPedidoNull(id);
        pedidoRepository.deleteById(id);
    }
}