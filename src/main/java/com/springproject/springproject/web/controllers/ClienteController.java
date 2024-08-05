package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.ClienteDTO;
import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.persistence.entities.Ciudad;
import com.springproject.springproject.persistence.entities.Empleado;
import com.springproject.springproject.persistence.entities.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("formulario/{id}")
    public Optional<Cliente> formulario(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setIdCliente(id);
        clienteService.update(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream()
                                           .map(cliente -> new ClienteDTO(cliente))
                                           .collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id " + id));
        List<Ciudad> ciudades = ciudadService.findAll();
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("empleados", empleados);
        return "clientes/cliente-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}


