package com.springproject.springproject.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springproject.springproject.domain.dto.PagoDTO;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.domain.services.FormaPago.FormaPagoService;
import com.springproject.springproject.domain.services.Pago.PagoService;
import com.springproject.springproject.persistence.entities.Pago;
import com.springproject.springproject.persistence.entities.Cliente;
import com.springproject.springproject.persistence.entities.FormaPago;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FormaPagoService formaPagoService;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> listarPagos() {
        List<Pago> pagos = pagoService.findAll();
        List<PagoDTO> pagoDTO = pagos.stream().map(PagoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(pagoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> obtenerPago(@PathVariable Long id) {
        Optional<Pago> pago = pagoService.findById(id);
        return pago.map(p -> ResponseEntity.ok(new PagoDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PagoDTO> crearPago(@RequestBody PagoDTO pagoDTO) {
        Optional<Cliente> clienteOp = clienteService.findById(pagoDTO.getIdCliente());
        Optional<FormaPago> formaPagoOp = formaPagoService.findById(pagoDTO.getIdFormaPago());

        if (clienteOp.isEmpty() || formaPagoOp.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Pago pago = new Pago();
        pago.setIdPago(pagoDTO.getIdPago());
        pago.setCliente(clienteOp.get());
        pago.setFormaPago(formaPagoOp.get());
        pago.setFechaPago(pagoDTO.getFechaPago());
        pago.setTotal(pagoDTO.getTotal());

        Pago nuevoPago = pagoService.save(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PagoDTO(nuevoPago));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PagoDTO> actualizarPago(@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        if (!pagoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Cliente> clienteOp = clienteService.findById(pagoDTO.getIdCliente());
        Optional<FormaPago> formaPagoOp = formaPagoService.findById(pagoDTO.getIdFormaPago());

        if (clienteOp.isEmpty() || formaPagoOp.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Pago pago = new Pago();
        pago.setIdPago(id);
        pago.setCliente(clienteOp.get());
        pago.setFormaPago(formaPagoOp.get());
        pago.setFechaPago(pagoDTO.getFechaPago());
        pago.setTotal(pagoDTO.getTotal());

        Pago pagoActualizado = pagoService.update(id, pago);
        return ResponseEntity.ok(new PagoDTO(pagoActualizado));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        if (pagoService.findById(id).isPresent()) {
            pagoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
