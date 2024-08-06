package com.springproject.springproject.domain.services.Pago;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.persistence.entities.Pago;
import com.springproject.springproject.persistence.repositories.PagoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    PagoRepository pagoRepository;

    
    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }
    
    @Override
    public Pago update(Long id, Pago pago) {
        if(!pagoRepository.existsById(id)){
            throw new EntityNotFoundException("Pago no encontrado con id:" + id);
        }
        pago.setIdPago(id);
        return pagoRepository.save(pago);
    }
    
    @Override
    public Optional<Pago> delete(Long id) {
        Optional<Pago> pago = pagoRepository.findById(id);
        if (pago.isPresent()) {
            pagoRepository.deleteById(id);
        }
        return pago;
    }
}