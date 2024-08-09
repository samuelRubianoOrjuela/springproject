package com.springproject.springproject.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.GamaProductoDTO;
import com.springproject.springproject.domain.services.GamaProducto.GamaProductoService;
import com.springproject.springproject.persistence.entities.GamaProducto;


@RestController
@RequestMapping("/gama")
public class GamaProductoController {

    @Autowired
    private final GamaProductoService gamaProductoService;

    public GamaProductoController(GamaProductoService gamaProductoService) {
        this.gamaProductoService = gamaProductoService;
    }

    @GetMapping
    public ResponseEntity<List<GamaProductoDTO>> listarGamaProducto() {
        List<GamaProducto> gamaProductos = gamaProductoService.findAll();
        List<GamaProductoDTO> gamaProductoDTOs = gamaProductos.stream().map(GamaProductoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(gamaProductoDTOs);
    }

    @GetMapping("/{gama}")
    public ResponseEntity<GamaProductoDTO> obtenerGamaProducto(@PathVariable String gama) {
        Optional<GamaProducto> gamaProducto = gamaProductoService.findById(gama);
        return gamaProducto.map(p -> ResponseEntity.ok(new GamaProductoDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<GamaProductoDTO> crearGamaProducto(@RequestBody GamaProducto gamaProducto) {
        GamaProducto nuevaGamaProducto = gamaProductoService.save(gamaProducto);
        return ResponseEntity.status(201).body(new GamaProductoDTO(nuevaGamaProducto));
    }

    @PutMapping("/actualizar/{gama}")
    public ResponseEntity<GamaProductoDTO> actualizarGamaProducto(@PathVariable String gama, @RequestBody GamaProducto gamaProducto) {
        if (gamaProductoService.findById(gama).isPresent()) {
            gamaProducto.setGama(gama);
            GamaProducto gamaActualizado = gamaProductoService.update(gama, gamaProducto);
            return ResponseEntity.ok(new GamaProductoDTO(gamaActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{gama}")
    public ResponseEntity<Void> eliminarGamaProducto(@PathVariable String gama) {
        if (gamaProductoService.findById(gama).isPresent()) {
            gamaProductoService.delete(gama);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}