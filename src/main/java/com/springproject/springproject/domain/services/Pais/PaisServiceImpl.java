package com.springproject.springproject.domain.services.Pais;

import com.springproject.springproject.persistence.entities.Pais;
import com.springproject.springproject.persistence.repositories.CiudadRepository;
import com.springproject.springproject.persistence.repositories.PaisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final CiudadRepository ciudadRepository;

    public PaisServiceImpl(PaisRepository paisRepository, CiudadRepository ciudadRepository) {
        this.paisRepository = paisRepository;
        this.ciudadRepository = ciudadRepository;
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
    @Transactional
    public Pais update(Long id, Pais pais) {
        if (paisRepository.existsById(id)) {
            pais.setIdPais(id);
            return paisRepository.save(pais);
        } else {
            throw new RuntimeException("Pais no encontrado con id " + id);
        }
    }

    @Override
    @Transactional
    public Optional<Pais> delete(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            ciudadRepository.setPaisToNullById(id);
            paisRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pais no encontrado con id " + id);
        }
        return pais;
    }
}
