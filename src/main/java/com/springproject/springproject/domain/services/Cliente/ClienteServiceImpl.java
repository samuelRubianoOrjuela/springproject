package com.springproject.springproject.domain.services.Cliente;

import com.springproject.springproject.persistence.entities.Cliente;
import com.springproject.springproject.persistence.repositories.ClienteRepository;
import com.springproject.springproject.persistence.repositories.PagoRepository;
import com.springproject.springproject.persistence.repositories.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, PagoRepository pagoRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.pagoRepository = pagoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente update(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente no encontrado con id " + id);
        }
        cliente.setIdCliente(id); 
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Optional<Cliente> delete(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            pagoRepository.setClienteNullPago(id);
            pedidoRepository.setClienteNullPedido(id);

            clienteRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cliente no encontrado con id " + id);
        }
        return cliente;
    }
}
