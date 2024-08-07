package com.springproject.springproject.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.domain.dto.DimensionesDTO;
import com.springproject.springproject.domain.services.Dimensiones.DimensionesService;
import com.springproject.springproject.persistence.entities.Dimensiones;


@RestController
@RequestMapping("/dimension")
public class DimensionesController {

    private final DimensionesService dimensionesService;

    public DimensionesController(DimensionesService dimensionesService) {
        this.dimensionesService = dimensionesService;
    }

    @GetMapping
    public ResponseEntity<List<DimensionesDTO>> listarDimensiones() {
        List<Dimensiones> dimensiones = dimensionesService.findAll();
        List<DimensionesDTO> dimensionesDTO = dimensiones.stream().map(DimensionesDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dimensionesDTO);
    }

    @GetMapping("/dimensiones/{id}")
    public ResponseEntity<DimensionesDTO> obtenerDimensiones(@PathVariable Long id) {
        Optional<Dimensiones> dimensiones = dimensionesService.findById(id);
        return dimensiones.map(p -> ResponseEntity.ok(new DimensionesDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DimensionesDTO> crearDimensiones(@RequestBody Dimensiones dimensiones) {
        Dimensiones nuevaDimensiones = dimensionesService.save(dimensiones);
        return ResponseEntity.status(201).body(new DimensionesDTO(nuevaDimensiones));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DimensionesDTO> actualizarDimensiones(@PathVariable Long id, @RequestBody Dimensiones dimensiones) {
        if (dimensionesService.findById(id).isPresent()) {
            dimensiones.setIdDimensiones(id);
            Dimensiones dimensionesActualizado = dimensionesService.update(id, dimensiones);
            return ResponseEntity.ok(new DimensionesDTO(dimensionesActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDimensiones(@PathVariable Long id) {
        if (dimensionesService.findById(id).isPresent()) {
            dimensionesService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
