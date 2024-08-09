package com.springproject.springproject.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.EstadoPedidoDTO;
import com.springproject.springproject.domain.services.EstadoPedido.EstadoPedidoService;
import com.springproject.springproject.persistence.entities.EstadoPedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estado")
public class EstadoPedidoController {
    
    private final EstadoPedidoService estadoPedidoService;

    public EstadoPedidoController(EstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }
    
    @GetMapping
    public ResponseEntity<List<EstadoPedidoDTO>> listarEstadosPedido() {
        List<EstadoPedido> estadoPedidos = estadoPedidoService.findAll();
        List<EstadoPedidoDTO> estadoPedidoDTOs = estadoPedidos.stream().map(EstadoPedidoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(estadoPedidoDTOs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedidoDTO> obtenerEstadoPedido(@PathVariable Long id) {
        Optional<EstadoPedido> estadoPedido = estadoPedidoService.findById(id);
        return estadoPedido.map(o -> ResponseEntity.ok(new EstadoPedidoDTO(o))).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/nuevo")
    public ResponseEntity<EstadoPedidoDTO> crearEstadoPedido(@RequestBody EstadoPedidoDTO estadoPedidoDTO) {
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setIdEstado(estadoPedido.getIdEstado());
        estadoPedido.setNombreEstado(estadoPedidoDTO.getNombreEstado());

        EstadoPedido nuevoEstadoPedido = estadoPedidoService.save(estadoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EstadoPedidoDTO(nuevoEstadoPedido));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstadoPedidoDTO> actualizarEstadoPedido(@PathVariable Long id, @RequestBody EstadoPedidoDTO estadoPedidoDTO) {
        Optional<EstadoPedido> estadoPedidoOpt = estadoPedidoService.findById(id);
        if (estadoPedidoOpt.isPresent()) {
            EstadoPedido estadoPedido = estadoPedidoOpt.get();
            estadoPedido.setNombreEstado(estadoPedidoDTO.getNombreEstado());

            EstadoPedido estadoPedidoActualizado = estadoPedidoService.save(estadoPedido);
            return ResponseEntity.ok(new EstadoPedidoDTO(estadoPedidoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEstadoPedido(@PathVariable Long id) {
        if (estadoPedidoService.findById(id).isPresent()) {
            estadoPedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}