package com.springproject.springproject.domain.services.Producto;


import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Producto;
import com.springproject.springproject.persistence.repositories.DetallePedidoRepository;
import com.springproject.springproject.persistence.repositories.ProductoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;


    

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto producto) {
        if (!productoRepository.existsById(id)) {
            throw new EntityNotFoundException("Producto no encontrado con id " + id);
        }
        producto.setIdProducto(id); 
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Optional<Producto> delete(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            detallePedidoRepository.setProductoNull(id);
            productoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Producto no encontrado con id " + id);
        }
        return producto;
    }
    

}