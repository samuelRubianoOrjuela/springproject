package com.springproject.springproject.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.ProveedorDTO;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Proveedor.ProveedorService;
import com.springproject.springproject.persistence.entities.Proveedor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    
    private final ProveedorService proveedorService;
    private final CiudadService ciudadService;

    public ProveedorController(ProveedorService proveedorService, CiudadService ciudadService) {
        this.proveedorService = proveedorService;
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.findAll();
        List<ProveedorDTO> proveedoresDTO = proveedores.stream().map(ProveedorDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(proveedoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> obtenerProveedor(@PathVariable Long id) {
        Optional<Proveedor> proveedor = proveedorService.findById(id);
        return proveedor.map(o -> ResponseEntity.ok(new ProveedorDTO(o))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProveedorDTO> crearProveedor(@RequestBody Proveedor proveedor){
        if (ciudadService.findById(proveedor.getCiudad().getIdCiudad()).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Proveedor nuevoProveedor = proveedorService.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProveedorDTO(nuevoProveedor));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        if (proveedorService.findById(id).isPresent()) {
            proveedor.setIdProveedor(id);
            Proveedor proveedorActualizado = proveedorService.update(id, proveedor);
            return ResponseEntity.ok(new ProveedorDTO(proveedorActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        if (proveedorService.findById(id).isPresent()) {
            proveedorService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}