package com.springproject.springproject.domain.services.Proveedor;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Proveedor;
import com.springproject.springproject.persistence.repositories.ProveedorRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public Proveedor update(Long id, Proveedor proveedor) {
        if (!proveedorRepository.existsById(id)) {
            throw new EntityNotFoundException("Proveedor no encontrada con id " + id);
        }
        proveedor.setIdProveedor(id); 
        return proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public Optional<Proveedor> delete(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if (proveedor.isPresent()) {
            proveedorRepository.deleteById(id);
        }
        return proveedor;
    }
}