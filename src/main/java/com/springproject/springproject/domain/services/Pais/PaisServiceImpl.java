package com.springproject.springproject.domain.services.Pais;

import com.springproject.springproject.persistence.entities.Pais;
import com.springproject.springproject.persistence.repositories.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Pais update(Long id, Pais pais) {
        if (paisRepository.existsById(id)) {
            pais.setId(id);
            return paisRepository.save(pais);
        } else {
            throw new RuntimeException("Pais no encontrado con id " + id);
        }
    }

    @Override
    public Optional<Pais> delete(Long id) {
        paisRepository.deleteById(id);
        return null;
    }
}
