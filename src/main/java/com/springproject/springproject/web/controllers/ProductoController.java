package com.springproject.springproject.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.springproject.springproject.domain.dto.ProductoDTO;
import com.springproject.springproject.domain.services.Dimensiones.DimensionesService;
import com.springproject.springproject.domain.services.GamaProducto.GamaProductoService;
import com.springproject.springproject.domain.services.Producto.ProductoService;
import com.springproject.springproject.domain.services.Proveedor.ProveedorService;
import com.springproject.springproject.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("producto")
public class ProductoController {
    
    @Autowired
    private final ProductoService productoService;
    private final DimensionesService dimensionesService;
    private final GamaProductoService gamaProductoService;
    private final ProveedorService proveedorService;

    public ProductoController(ProductoService productoService, DimensionesService dimensionesService, GamaProductoService gamaProductoService, ProveedorService proveedorService) {
        this.productoService = productoService;
        this.dimensionesService = dimensionesService;
        this.gamaProductoService = gamaProductoService;
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        List<Producto> productos = productoService.findAll();
        List<ProductoDTO> productoDTOs = productos.stream().map(ProductoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(productoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerCiudad(@PathVariable Long id) {
        Optional<Producto> productos = productoService.findById(id);
        return productos.map(c -> ResponseEntity.ok(new ProductoDTO(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProductoDTO> nuevoProducto(@RequestBody ProductoDTO productoDTO) {
        if (dimensionesService.findById(productoDTO.getIdDimensiones()).isEmpty() ||
            gamaProductoService.findById(productoDTO.getGama()).isEmpty() ||
            proveedorService.findById(productoDTO.getIdProveedor()).isEmpty()) {
            return ResponseEntity.badRequest().build();     
        }
    
        Producto producto = new Producto();
        producto.setIdProducto(productoDTO.getIdProducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setPrecioProveedor(productoDTO.getPrecioProveedor());
        producto.setCantidadEnStock(productoDTO.getCantidadEnStock());

        producto.setGamaProducto(gamaProductoService.findById(productoDTO.getGama()).orElse(null));
        producto.setDimensiones(dimensionesService.findById(productoDTO.getIdDimensiones()).orElse(null));
        producto.setProveedor(proveedorService.findById(productoDTO.getIdProveedor()).orElse(null));
    
        Producto productoNuevo = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductoDTO(productoNuevo));
    }
    

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        if (productoService.findById(id).isPresent()) {
            if (dimensionesService.findById(productoDTO.getIdDimensiones()).isEmpty() ||
                gamaProductoService.findById(productoDTO.getGama()).isEmpty() ||
                proveedorService.findById(productoDTO.getIdProveedor()).isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Producto producto = new Producto();
            producto.setIdProducto(id);
            producto.setNombre(productoDTO.getNombre());
            producto.setGamaProducto(gamaProductoService.findById(productoDTO.getGama()).orElse(null));
            producto.setDimensiones(dimensionesService.findById(productoDTO.getIdDimensiones()).orElse(null));
            producto.setProveedor(proveedorService.findById(productoDTO.getIdProveedor()).orElse(null));
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecioVenta(productoDTO.getPrecioVenta());
            producto.setPrecioProveedor(productoDTO.getPrecioProveedor());
            producto.setCantidadEnStock(productoDTO.getCantidadEnStock());
    
            Producto productoActualizado = productoService.update(id, producto);
            return ResponseEntity.ok(new ProductoDTO(productoActualizado));
        } else {
            return ResponseEntity.notFound().build();    
        }




    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (!productoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}