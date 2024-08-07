package com.springproject.springproject.domain.services.Direccion;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Direccion;
import com.springproject.springproject.persistence.repositories.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {
    
    @Autowired
    private final DireccionRepository direccionRepository;


    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Override
    public List<Direccion> findAll() {
        return (List<Direccion>) direccionRepository.findAll();
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public Direccion update(Long id, Direccion direccion) {
        if (!direccionRepository.existsById(id)) {
            throw new EntityNotFoundException("Direccion no encontrada con id " + id);
        }
        direccion.setIdDireccion(id); 
        return direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        direccionRepository.unsetDireccionClientes(id);
        direccionRepository.deleteIdDireccion(id);
    }

}