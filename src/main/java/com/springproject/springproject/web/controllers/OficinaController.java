package com.springproject.springproject.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.OficinaDTO;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Oficina.OficinaService;
import com.springproject.springproject.persistence.entities.Oficina;
import com.springproject.springproject.persistence.entities.Ciudad;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/oficina")
public class OficinaController {
    
    private final OficinaService oficinaService;
    private final CiudadService ciudadService;
    
    public OficinaController(OficinaService oficinaService, CiudadService ciudadService) {
        this.oficinaService = oficinaService;
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<OficinaDTO>> listarOficinas() {
        List<Oficina> oficinas = oficinaService.findAll();
        List<OficinaDTO> oficinaDTOs = oficinas.stream().map(OficinaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(oficinaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficinaDTO> obtenerOficina(@PathVariable Long id) {
        Optional<Oficina> oficina = oficinaService.findById(id);
        return oficina.map(o -> ResponseEntity.ok(new OficinaDTO(o))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<OficinaDTO> crearOficina(@RequestBody OficinaDTO oficinaDTO) {
        Optional<Ciudad> ciudadOpt = ciudadService.findById(oficinaDTO.getIdCiudad());
        if (ciudadOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Oficina oficina = new Oficina();
        oficina.setTelefono(oficinaDTO.getTelefono());
        oficina.setLineaDireccion1(oficinaDTO.getLineaDireccion1());
        oficina.setLineaDireccion2(oficinaDTO.getLineaDireccion2());
        oficina.setIdCiudad(ciudadOpt.get());

        Oficina nuevaOficina = oficinaService.save(oficina);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OficinaDTO(nuevaOficina));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<OficinaDTO> actualizarOficina(@PathVariable Long id, @RequestBody OficinaDTO oficinaDTO) {
        Optional<Oficina> oficinaOpt = oficinaService.findById(id);
        if (oficinaOpt.isPresent()) {
            Oficina oficina = oficinaOpt.get();
            Optional<Ciudad> ciudadOpt = ciudadService.findById(oficinaDTO.getIdCiudad());
            if (ciudadOpt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            oficina.setTelefono(oficinaDTO.getTelefono());
            oficina.setLineaDireccion1(oficinaDTO.getLineaDireccion1());
            oficina.setLineaDireccion2(oficinaDTO.getLineaDireccion2());
            oficina.setIdCiudad(ciudadOpt.get());

            Oficina oficinaActualizada = oficinaService.save(oficina);
            return ResponseEntity.ok(new OficinaDTO(oficinaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")    
    public ResponseEntity<Void> eliminarOficina(@PathVariable Long id) {
        if (oficinaService.findById(id).isPresent()) {
            oficinaService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

