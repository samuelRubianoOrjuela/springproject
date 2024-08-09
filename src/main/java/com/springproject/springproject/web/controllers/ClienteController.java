package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.ClienteDTO;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.domain.services.Direccion.DireccionService;
import com.springproject.springproject.persistence.entities.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;
    private final CiudadService ciudadService;
    private final EmpleadoService empleadoService;
    private final DireccionService direccionService;
    
    public ClienteController(ClienteService clienteService, CiudadService ciudadService, EmpleadoService empleadoService, DireccionService direccionService) {
        this.clienteService = clienteService;
        this.ciudadService = ciudadService;
        this.empleadoService = empleadoService;
        this.direccionService = direccionService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCiudad(@PathVariable Long id) {
        Optional<Cliente> clientes = clienteService.findById(id);
        return clientes.map(c -> ResponseEntity.ok(new ClienteDTO(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        if (ciudadService.findById(clienteDTO.getCiudadId()).isEmpty() ||
            empleadoService.findById(clienteDTO.getEmpleadoRepVentasId()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setNombreContacto(clienteDTO.getNombreContacto());
        cliente.setApellidoCliente(clienteDTO.getApellidoCliente());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setFax(clienteDTO.getFax());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setLimiteCredito(clienteDTO.getLimiteCredito());

        cliente.setCiudad(ciudadService.findById(clienteDTO.getCiudadId()).orElse(null));
        cliente.setDireccion(direccionService.findById(clienteDTO.getDireccionId()).orElse(null));
        cliente.setEmpleadoRepVentas(empleadoService.findById(clienteDTO.getEmpleadoRepVentasId()).orElse(null));
        
        Cliente nuevoCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(nuevoCliente));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setNombreContacto(clienteDTO.getNombreContacto());
        cliente.setApellidoCliente(clienteDTO.getApellidoCliente());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setFax(clienteDTO.getFax());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setLimiteCredito(clienteDTO.getLimiteCredito());
        
        if (ciudadService.findById(clienteDTO.getCiudadId()).isEmpty() || 
            direccionService.findById(clienteDTO.getDireccionId()).isEmpty() || 
            empleadoService.findById(clienteDTO.getEmpleadoRepVentasId()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        cliente.setCiudad(ciudadService.findById(clienteDTO.getCiudadId()).get());
        cliente.setDireccion(direccionService.findById(clienteDTO.getDireccionId()).get());
        cliente.setEmpleadoRepVentas(empleadoService.findById(clienteDTO.getEmpleadoRepVentasId()).get());

        clienteService.update(id, cliente);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (!clienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


