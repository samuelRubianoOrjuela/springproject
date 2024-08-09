package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.FormaPagoDTO;
import com.springproject.springproject.domain.services.FormaPago.FormaPagoService;
import com.springproject.springproject.persistence.entities.FormaPago;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formaPago")
public class FormaPagoController {

    private final FormaPagoService formaPagoService;

    public FormaPagoController(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }

    @GetMapping
    public ResponseEntity<List<FormaPagoDTO>> listarFormasPago() {
        List<FormaPago> formasPago = formaPagoService.findAll();
        List<FormaPagoDTO> formasPagoDTO = formasPago.stream().map(FormaPagoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(formasPagoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagoDTO> obtenerFormaPago(@PathVariable Long id) {
        Optional<FormaPago> formaPago = formaPagoService.findById(id);
        return formaPago.map(f -> ResponseEntity.ok(new FormaPagoDTO(f))).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping("/nuevo")
    public ResponseEntity<FormaPagoDTO> crearFormaPago(@RequestBody FormaPagoDTO formaPagoDTO) {
        FormaPago formaPago = new FormaPago();
        formaPago.setNombreFormaPago(formaPagoDTO.getNombreFormaPago());

        FormaPago nuevoFormaPago = formaPagoService.save(formaPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FormaPagoDTO(nuevoFormaPago));
    }



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FormaPagoDTO> actualizarFormaPago(@PathVariable Long id, @RequestBody FormaPagoDTO formaPagoDTO) {
        Optional<FormaPago> formaPagoOpt = formaPagoService.findById(id);
        if (formaPagoOpt.isPresent()) {
            FormaPago formaPago = formaPagoOpt.get();
            formaPago.setNombreFormaPago(formaPagoDTO.getNombreFormaPago());

            FormaPago formaPagoActualizado = formaPagoService.update(id, formaPago);
            return ResponseEntity.ok(new FormaPagoDTO(formaPagoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFormaPago(@PathVariable Long id) {
        Optional<FormaPago> formaPago = formaPagoService.delete(id);
        return formaPago.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}