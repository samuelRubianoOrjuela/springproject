package com.springproject.springproject.domain.services.Puesto;

import com.springproject.springproject.persistence.entities.Puesto;
import com.springproject.springproject.persistence.repositories.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoServiceImpl implements PuestoService {

    @Autowired
    private final PuestoRepository puestoRepository;

    
    public PuestoServiceImpl(PuestoRepository puestoRepository) {
        this.puestoRepository = puestoRepository;
    }

    @Override
    public List<Puesto> findAll() {
        return puestoRepository.findAll();
    }

    @Override
    public Optional<Puesto> findById(Long id) {
        return puestoRepository.findById(id);
    }

    @Override
    public Puesto save(Puesto puesto) {
        return puestoRepository.save(puesto);
    }

    @Override
    public Puesto update(Long id, Puesto puesto) {
        if (puestoRepository.existsById(id)) {
            puesto.setIdPuesto(id);
            return puestoRepository.save(puesto);
        }
        return null;
    }

    @Override
    public Optional<Puesto> delete(Long id) {
        if (puestoRepository.existsById(id)) {
            puestoRepository.deleteById(id);
        }
        return Optional.empty();
    }
}
