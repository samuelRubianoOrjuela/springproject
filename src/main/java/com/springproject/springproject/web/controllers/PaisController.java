package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.services.Pais.PaisService;
import com.springproject.springproject.persistence.entities.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public String listarPaises(Model model) {
        model.addAttribute("paises", paisService.findAll());
        return "paises/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("pais", new Pais());
        return "paises/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPais(@ModelAttribute Pais pais) {
        paisService.save(pais);
        return "redirect:/paises";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Pais pais = paisService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("País no encontrado con id " + id));
        model.addAttribute("pais", pais);
        return "paises/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPais(@PathVariable Long id, @ModelAttribute Pais pais) {
        paisService.update(id, pais);
        return "redirect:/paises";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPais(@PathVariable Long id) {
        paisService.delete(id);
        return "redirect:/paises";
    }
}
