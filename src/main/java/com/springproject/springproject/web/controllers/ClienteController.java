package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.domain.services.Cliente.ClienteService;
import com.springproject.springproject.persistence.entities.Ciudad;
import com.springproject.springproject.persistence.entities.Empleado;
import com.springproject.springproject.persistence.entities.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClienteController {

    private final ClienteService clienteService;
    private final CiudadService ciudadService;
    private final EmpleadoService empleadoService;

    public ClienteController(ClienteService clienteService, CiudadService ciudadService, EmpleadoService empleadoService) {
        this.clienteService = clienteService;
        this.ciudadService = ciudadService;
        this.empleadoService = empleadoService;
    }

    @GetMapping("/clientes/formulario")
    public String formulario(@RequestParam(required = false) Long id, Model model) {
        Cliente cliente = (id != null) ? clienteService.findById(id).orElse(new Cliente()) : new Cliente();
        List<Ciudad> ciudades = ciudadService.findAll();
        List<Empleado> empleados = empleadoService.findAll();
        
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("empleados", empleados);
        return "clientes/cliente-form";
    }

    @PostMapping("/clientes/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setIdCliente(id);
        clienteService.update(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/lista";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id " + id));
        List<Ciudad> ciudades = ciudadService.findAll();
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("empleados", empleados);
        return "clientes/cliente-form";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}


