package com.springproject.springproject.domain.services.DetallePedido;

import com.springproject.springproject.persistence.entities.DetallePedido;
import com.springproject.springproject.persistence.repositories.DetallePedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private final DetallePedidoRepository detallePedidoRepository;

    
    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> findById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public DetallePedido save(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    @Transactional
    public DetallePedido update(Long id, DetallePedido detallePedido) {
        if (!detallePedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Detalle Pedido no encontrado con id " + id);
        }
        detallePedido.setIdDetallePedido(id);
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    @Transactional
    public Optional<DetallePedido> delete(Long id) {
        Optional<DetallePedido> detallePedido = detallePedidoRepository.findById(id);
        if (!detallePedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Detalle Pedido no encontrado con id " + id);
        }
        detallePedidoRepository.deleteById(id);
        return detallePedido;
    }
}
