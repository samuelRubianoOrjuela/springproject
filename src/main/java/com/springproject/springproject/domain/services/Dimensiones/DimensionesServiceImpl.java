package com.springproject.springproject.domain.services.Dimensiones;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Dimensiones;
import com.springproject.springproject.persistence.repositories.DimensionesRepository;


@Service
public class DimensionesServiceImpl implements DimensionesService {

    @Autowired
    private final DimensionesRepository dimensionesRepository;

    public DimensionesServiceImpl(DimensionesRepository dimensionesRepository) {
        this.dimensionesRepository = dimensionesRepository;
    }

    @Override
    public List<Dimensiones> findAll() {
        return (List<Dimensiones>) dimensionesRepository.findAll();
    }

    @Override
    public Optional<Dimensiones> findById(Long id) {
        return dimensionesRepository.findById(id);
    }

    @Override
    public Dimensiones save(Dimensiones dimensiones) {
        return dimensionesRepository.save(dimensiones);
    }

    @Override
    @Transactional
    public Dimensiones update(Long id, Dimensiones dimensiones) {
        if (!dimensionesRepository.existsById(id)) {
            throw new EntityNotFoundException("Dimensiones no encontradas con id " + id);
        }
        dimensiones.setIdDimensiones(id); 
        return dimensionesRepository.save(dimensiones);
    }

    @Override
    @Transactional
    public Optional<Dimensiones> delete(Long id) {
        Optional<Dimensiones> dimensiones = dimensionesRepository.findById(id);
        if (dimensiones.isPresent()) {
            dimensionesRepository.deleteById(id);
        }
        return dimensiones;
    }
}
