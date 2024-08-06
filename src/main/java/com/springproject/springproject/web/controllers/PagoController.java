package com.springproject.springproject.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.domain.dto.PagoDTO;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.domain.services.FormaPago.FormaPagoService;
import com.springproject.springproject.domain.services.Pago.PagoService;
import com.springproject.springproject.persistence.entities.Pago;


@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final ClienteService clienteService;
    private final FormaPagoService formaPagoService;
    private final PagoService pagoService;

    public PagoController(ClienteService clienteService, FormaPagoService formaPagoService, PagoService pagoService) {
        this.clienteService = clienteService;
        this.formaPagoService = formaPagoService;
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> listarPagos (){
        List<Pago> pagos = pagoService.findAll();
        List<PagoDTO> pagosDTO = pagos.stream().map(pago -> new PagoDTO(pago))
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(pagosDTO);
    }


}
