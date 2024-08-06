package com.springproject.springproject.domain.services.Oficina;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Oficina;
import com.springproject.springproject.persistence.repositories.OficinaRepository;

@Service
public class OficinaServiceImpl implements OficinaService{
    
    @Autowired
    private final OficinaRepository oficinaRepository;

    public OficinaServiceImpl(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    @Override
    public List<Oficina> findAll() {
        return (List<Oficina>) oficinaRepository.findAll();
    }

    @Override
    public Optional<Oficina> findById(Long id) {
        return oficinaRepository.findById(id);
    } 

    @Override
    public Oficina save(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @Override
    @Transactional
    public Oficina update(Long id, Oficina oficina) {
        if (!oficinaRepository.existsById(id)) {
            throw new EntityNotFoundException("Oficina no encontrada con id " + id);
        }
        oficina.setIdOficina(id); 
        return oficinaRepository.save(oficina);
    }

    @Override
    @Transactional
    public Optional<Oficina> delete(Long id) {
        Optional<Oficina> oficina = oficinaRepository.findById(id);
        if (oficina.isPresent()) {
            oficinaRepository.deleteById(id);
        }
        return oficina;
    }
}
