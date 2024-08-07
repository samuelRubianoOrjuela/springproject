package com.springproject.springproject.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.domain.dto.PuestoDTO;
import com.springproject.springproject.domain.services.Puesto.PuestoService;
import com.springproject.springproject.persistence.entities.Puesto;

@RestController
@RequestMapping("/puesto")
public class PuestoController {
    
    private final PuestoService puestoService;

    public PuestoController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping
    public ResponseEntity<List<PuestoDTO>> listarPuestos() {
        List<Puesto> puestos = puestoService.findAll();
        List<PuestoDTO> puestosDTO = puestos.stream().map(PuestoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(puestosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuestoDTO> obtenerPuesto(@PathVariable Long id){
        Optional<Puesto> puesto = puestoService.findById(id);
        return puesto.map(p -> ResponseEntity.ok(new PuestoDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
