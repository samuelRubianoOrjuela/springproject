package com.springproject.springproject.domain.services.FormaPago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.springproject.persistence.entities.FormaPago;
import com.springproject.springproject.persistence.repositories.FormaPagoRepository;
import com.springproject.springproject.persistence.repositories.PagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoServiceImpl implements FormaPagoService {

    @Autowired
    private final FormaPagoRepository formaPagoRepository;

    @Autowired
    private PagoRepository pagoRepository;
    
    public FormaPagoServiceImpl(FormaPagoRepository formaPagoRepository) {
        this.formaPagoRepository = formaPagoRepository;
    }

    @Override
    public List<FormaPago> findAll() {
        return formaPagoRepository.findAll();
    }

    @Override
    public Optional<FormaPago> findById(Long id) {
        return formaPagoRepository.findById(id);
    }

    @Override
    public FormaPago save(FormaPago formaPago) {
        return formaPagoRepository.save(formaPago);
    }

    @Override
    public FormaPago update(Long id, FormaPago formaPago) {
        if (formaPagoRepository.existsById(id)) {
            formaPago.setIdFormaPago(id);
            return formaPagoRepository.save(formaPago);
        } else {
            throw new RuntimeException("Forma Pago no encontrada con id " + id);
        }
    }

    @Override
    public Optional<FormaPago> delete(Long id) {
        Optional<FormaPago> formaPago = formaPagoRepository.findById(id);
        if (formaPago.isPresent()) {
            pagoRepository.setFormaPagoNull(id);
            formaPagoRepository.deleteById(id);
        }
        return formaPago;
    }
}
