package com.springproject.springproject.domain.services.Ciudad;

import java.util.List;
import java.util.Optional;
import com.springproject.springproject.persistence.entities.Ciudad;
import com.springproject.springproject.persistence.repositories.CiudadRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad update(Long id, Ciudad ciudad) {
        if (!ciudadRepository.existsById(id)) {
            throw new EntityNotFoundException("Ciudad no encontrada con id " + id);
        }
        ciudad.setIdCiudad(id); 
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Optional<Ciudad> delete(Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if (ciudad.isPresent()) {
            ciudadRepository.deleteById(id);
        }
        return ciudad;
    }
}

