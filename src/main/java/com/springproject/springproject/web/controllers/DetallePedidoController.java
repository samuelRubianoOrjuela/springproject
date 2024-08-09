package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.DetallePedidoDTO;
import com.springproject.springproject.domain.services.DetallePedido.DetallePedidoService;
import com.springproject.springproject.domain.services.Pedido.PedidoService;
import com.springproject.springproject.domain.services.Producto.ProductoService;
import com.springproject.springproject.persistence.entities.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {

    @Autowired
    private final DetallePedidoService detallePedidoService;
    private final PedidoService pedidoService;
    private final ProductoService productoService;
    
    

    public DetallePedidoController(DetallePedidoService detallePedidoService, PedidoService pedidoService, ProductoService productoService) {
        this.detallePedidoService = detallePedidoService;
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> listarDetallesPedidos() {
        List<DetallePedido> detallesPedidos = detallePedidoService.findAll();
        List<DetallePedidoDTO> detallePedidoDTOs = detallesPedidos.stream()
            .map(DetallePedidoDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(detallePedidoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> obtenerDetallePedido(@PathVariable Long id) {
        Optional<DetallePedido> detallePedido = detallePedidoService.findById(id);
        return detallePedido.map(dp -> ResponseEntity.ok(new DetallePedidoDTO(dp))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DetallePedidoDTO> crearDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO) {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(detallePedidoDTO.getIdDetallePedido());
        detallePedido.setPedido(pedidoService.findById(detallePedidoDTO.getIdPedido()).orElse(null));
        detallePedido.setProducto(productoService.findById(detallePedidoDTO.getIdProducto()).orElse(null));
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecioUnidad(detallePedidoDTO.getPrecioUnidad());
        detallePedido.setNumeroLinea(detallePedidoDTO.getNumeroLinea());

        DetallePedido nuevoDetallePedido = detallePedidoService.save(detallePedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DetallePedidoDTO(nuevoDetallePedido));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DetallePedidoDTO> actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedidoDTO detallePedidoDTO) {
        if (!detallePedidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(detallePedidoDTO.getIdDetallePedido());
        detallePedido.setPedido(pedidoService.findById(detallePedidoDTO.getIdPedido()).orElse(null));
        detallePedido.setProducto(productoService.findById(detallePedidoDTO.getIdProducto()).orElse(null));
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecioUnidad(detallePedidoDTO.getPrecioUnidad());
        detallePedido.setNumeroLinea(detallePedidoDTO.getNumeroLinea());

        DetallePedido detallePedidoActualizado = detallePedidoService.update(id, detallePedido);
        return ResponseEntity.ok(new DetallePedidoDTO(detallePedidoActualizado));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable Long id) {
        if (detallePedidoService.findById(id).isPresent()) {
            detallePedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}