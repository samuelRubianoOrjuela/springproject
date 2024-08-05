package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.services.Ciudad.CiudadService;
import com.springproject.springproject.domain.services.Pais.PaisService;
import com.springproject.springproject.persistence.entities.Ciudad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;
    private final PaisService paisService;

    public CiudadController(CiudadService ciudadService, PaisService paisService) {
        this.ciudadService = ciudadService;
        this.paisService = paisService;
    }

    @GetMapping
    public String listarCiudades(Model model) {
        model.addAttribute("ciudades", ciudadService.findAll());
        return "ciudades/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("ciudad", new Ciudad());
        model.addAttribute("paises", paisService.findAll());
        return "ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCiudad(@ModelAttribute Ciudad ciudad) {
        ciudadService.save(ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Ciudad ciudad = ciudadService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ciudad no encontrada con id " + id));
        model.addAttribute("ciudad", ciudad);
        model.addAttribute("paises", paisService.findAll());
        return "ciudades/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCiudad(@PathVariable Long id, @ModelAttribute Ciudad ciudad) {
        ciudadService.update(id, ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCiudad(@PathVariable Long id) {
        ciudadService.delete(id);
        return "redirect:/ciudades";
    }
}
