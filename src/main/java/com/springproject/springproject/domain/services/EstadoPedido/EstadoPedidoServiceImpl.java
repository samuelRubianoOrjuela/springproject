package com.springproject.springproject.domain.services.EstadoPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.EstadoPedido;
import com.springproject.springproject.persistence.repositories.EstadoPedidoRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPedidoServiceImpl implements EstadoPedidoService{

    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    public EstadoPedidoServiceImpl(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }


    @Override
    public List<EstadoPedido> findAll() {
        return estadoPedidoRepository.findAll();
    }

    @Override
    public Optional<EstadoPedido> findById(Long id) {
        return estadoPedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public EstadoPedido save(EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    @Override
    @Transactional
    public EstadoPedido update(Long id, EstadoPedido estadoPedido) {
        if (!estadoPedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Estado no encontrado con id " + id);
        }
        estadoPedido.setIdEstado(id); 
        return estadoPedidoRepository.save(estadoPedido);
    }

    @Override
    @Transactional
    public Optional<EstadoPedido> delete(Long id) {
        Optional<EstadoPedido> estadoPedido = estadoPedidoRepository.findById(id);
        if (estadoPedido.isPresent()) {
            estadoPedidoRepository.setEstadoNull(id);
            estadoPedidoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Estado no encontrado con id " + id);
        }
        return estadoPedido;
    }
}