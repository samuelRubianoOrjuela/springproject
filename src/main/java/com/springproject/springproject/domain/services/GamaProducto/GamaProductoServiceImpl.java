package com.springproject.springproject.domain.services.GamaProducto;


import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.GamaProducto;
import com.springproject.springproject.persistence.repositories.GamaProductoRepository;
import com.springproject.springproject.persistence.repositories.ProductoRepository;

@Service
public class GamaProductoServiceImpl implements GamaProductoService {
    
    @Autowired
    private final GamaProductoRepository gamaProductoRepository;

    public GamaProductoServiceImpl(GamaProductoRepository gamaProductoRepository) {
        this.gamaProductoRepository = gamaProductoRepository;
    }

    @Autowired
    private ProductoRepository productoRepository;

    
    @Override
    public List<GamaProducto> findAll(){
        return (List<GamaProducto> ) gamaProductoRepository.findAll();
    }

    @Override
    public Optional<GamaProducto> findById(String gama){
        return gamaProductoRepository.findById(gama);
    }

    @Override
    public GamaProducto save(GamaProducto gamaProducto){
        return gamaProductoRepository.save(gamaProducto);
    }

    @Override
    @Transactional
    public GamaProducto update(String gama, GamaProducto gamaProducto){
        if (!gamaProductoRepository.existsById(gama)){
            throw new EntityNotFoundException("Gama no encontrada con id " + gama);
        }
        gamaProducto.setGama(gama);
        return gamaProducto;
    }

    @Override
    @Transactional
    public Optional<GamaProducto> delete(String gama){
        Optional<GamaProducto> gamaProducto = gamaProductoRepository.findById(gama);
        if (gamaProducto.isPresent()){
            productoRepository.setGamaNull(gama);
            gamaProductoRepository.deleteById(gama);
        }
        return gamaProducto;
    }

}