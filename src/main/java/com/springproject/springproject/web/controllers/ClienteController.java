package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.ClienteDTO;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.persistence.entities.Ciudad;
import com.springproject.springproject.persistence.entities.Empleado;
import com.springproject.springproject.persistence.entities.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;
    private final CiudadService ciudadService;
    private final EmpleadoService empleadoService;

    public ClienteController(ClienteService clienteService, CiudadService ciudadService, EmpleadoService empleadoService) {
        this.clienteService = clienteService;
        this.ciudadService = ciudadService;
        this.empleadoService = empleadoService;
    }

    @GetMapping("/formulario/{id}")
    public ResponseEntity<Cliente> formulario(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        clienteService.update(id, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


