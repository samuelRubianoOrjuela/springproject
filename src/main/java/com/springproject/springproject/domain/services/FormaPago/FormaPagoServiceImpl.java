package com.springproject.springproject.domain.services.FormaPago;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springproject.springproject.persistence.entities.FormaPago;

@Service
public class FormaPagoServiceImpl implements FormaPagoService {

    @Override
    public Optional<FormaPago> delete(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<FormaPago> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FormaPago> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public FormaPago save(FormaPago formaPago) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FormaPago update(Long id, FormaPago formaPago) {
        // TODO Auto-generated method stub
        return null;
    }

}
