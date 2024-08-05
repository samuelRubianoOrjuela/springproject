package com.springproject.springproject.domain.services.Cliente;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Cliente;

public interface ClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Long id, Cliente cliente);
    Optional<Cliente> delete(Long id);
    
}
