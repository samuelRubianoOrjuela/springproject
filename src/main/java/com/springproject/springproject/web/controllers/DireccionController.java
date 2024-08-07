package com.springproject.springproject.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.DireccionDTO;
import com.springproject.springproject.domain.services.Direccion.DireccionService;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.persistence.entities.Direccion;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    private final DireccionService direccionService;
    private final CiudadService ciudadService;

    public DireccionController(DireccionService direccionService, CiudadService ciudadService) {
        this.direccionService = direccionService;
        this.ciudadService = ciudadService;
    }


    @GetMapping
    public ResponseEntity<List<DireccionDTO>> listarDirecciones() {
        List<Direccion> direcciones = direccionService.findAll();
        List<DireccionDTO> direccionesDTO = direcciones.stream().map(DireccionDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(direccionesDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> obtenerDireccion(@PathVariable Long id) {
        Optional<Direccion> direccion = direccionService.findById(id);
        return direccion.map(d -> ResponseEntity.ok(new DireccionDTO(d))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DireccionDTO> crearDireccion(@RequestBody DireccionDTO direccionDTO) {
        if (direccionDTO.getIdCiudad() == null || ciudadService.findById(direccionDTO.getIdCiudad()).isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Direccion direccion = new Direccion();
        direccion.setIdDireccion(direccionDTO.getIdDireccion());
        // direccion.setCliente(direccionDTO.getIdCliente() != null ? clienteService.findById(direccionDTO.getIdCliente()).orElse(null) : null);
        direccion.setTipoDireccion(direccionDTO.getTipoDireccion());
        direccion.setDireccion(direccionDTO.getDireccion());
        direccion.setDescripcion(direccionDTO.getDescripcion());
        direccion.setLineaDireccion1(direccionDTO.getLineaDireccion1());
        direccion.setLineaDireccion2(direccionDTO.getLineaDireccion2());
        direccion.setCiudad(ciudadService.findById(direccionDTO.getIdCiudad()).orElse(null));

        Direccion nuevaDireccion = direccionService.save(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DireccionDTO(nuevaDireccion));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DireccionDTO> actualizarDireccion(@PathVariable Long id, @RequestBody DireccionDTO direccionDTO) {
        if (direccionService.findById(id).isPresent()) {
            Direccion direccion = new Direccion();
            direccion.setIdDireccion(id);
            // direccion.setCliente(direccionDTO.getIdCliente() != null ? clienteService.findById(direccionDTO.getIdCliente()).orElse(null) : null);
            direccion.setTipoDireccion(direccionDTO.getTipoDireccion());
            direccion.setDireccion(direccionDTO.getDireccion());
            direccion.setDescripcion(direccionDTO.getDescripcion());
            direccion.setLineaDireccion1(direccionDTO.getLineaDireccion1());
            direccion.setLineaDireccion2(direccionDTO.getLineaDireccion2());
            direccion.setCiudad(ciudadService.findById(direccionDTO.getIdCiudad()).orElse(null));

            Direccion direccionActualizada = direccionService.update(id, direccion);
            return ResponseEntity.ok(new DireccionDTO(direccionActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Long id) {
        try {
            direccionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}