package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.PedidoDTO;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.domain.services.EstadoPedido.EstadoPedidoService;
import com.springproject.springproject.domain.services.Pago.PagoService;
import com.springproject.springproject.domain.services.Pedido.PedidoService;

import com.springproject.springproject.persistence.entities.Pedido;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PagoService pagoService;

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();
        List<PedidoDTO> pedidoDTOs = pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(pedidoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable Long id) {
        Optional<Pedido> pedidoOp = pedidoService.findById(id);
        return pedidoOp.map(pedido -> ResponseEntity.ok(new PedidoDTO(pedido))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setFechaPedido(pedidoDTO.getFechaPedido());
        pedido.setFechaEsperada(pedidoDTO.getFechaEsperada());
        pedido.setFechaEntrega(pedidoDTO.getFechaEntrega());
        pedido.setComentarios(pedidoDTO.getComentarios());
        pedido.setMetodoPago(pedidoDTO.getMetodoPago());
        pedido.setCliente(clienteService.findById(pedidoDTO.getIdCliente()).orElse(null));
        pedido.setPago(pagoService.findById(pedidoDTO.getIdPago()).orElse(null));
        pedido.setEstadoPedido(estadoPedidoService.findById(pedidoDTO.getIdEstadoPedido()).orElse(null));

        Pedido nuevoPedido = pedidoService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PedidoDTO(nuevoPedido));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PedidoDTO> actualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(id);
            pedido.setFechaPedido(pedidoDTO.getFechaPedido());
            pedido.setFechaEsperada(pedidoDTO.getFechaEsperada());
            pedido.setFechaEntrega(pedidoDTO.getFechaEntrega());
            pedido.setComentarios(pedidoDTO.getComentarios());
            pedido.setMetodoPago(pedidoDTO.getMetodoPago());
            pedido.setCliente(clienteService.findById(pedidoDTO.getIdCliente()).orElse(null));
            pedido.setPago(pagoService.findById(pedidoDTO.getIdPago()).orElse(null));
            pedido.setEstadoPedido(estadoPedidoService.findById(pedidoDTO.getIdEstadoPedido()).orElse(null));

            Pedido pedidoActualizado = pedidoService.update(id, pedido);
            return ResponseEntity.ok(new PedidoDTO(pedidoActualizado));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        try {
            pedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}