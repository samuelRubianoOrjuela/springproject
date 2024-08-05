package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.persistence.entities.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    
   private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
   
    @GetMapping
    public String listarEmpleados(Model model){
        model.addAttribute("empleados", empleadoService.findAll());
        return "empleados/lista";
    }
    

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model ) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute Empleado empleado) {
        empleadoService.update(id, empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.findById(id).orElseThrow(() -> new IllegalArgumentException("El empleado con id" + id + " no fue encontrado"));    
        model.addAttribute("empleado", empleado);
        return "empleados/formulario";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
        return "redirect:/empleados";
    }
    
}
