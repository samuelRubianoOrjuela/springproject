package com.springproject.springproject.web.controllers;

import com.springproject.springproject.domain.dto.EmpleadoDTO;
import com.springproject.springproject.domain.services.Empleado.EmpleadoService;
import com.springproject.springproject.domain.services.Puesto.PuestoService;
import com.springproject.springproject.persistence.entities.Empleado;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final PuestoService puestoService;


    public EmpleadoController(EmpleadoService empleadoService, PuestoService puestoService) {
        this.empleadoService = empleadoService;
        this.puestoService = puestoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        List<Empleado> empleados = empleadoService.findAll();
        List<EmpleadoDTO> empleadosDTO = empleados.stream().map(EmpleadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(empleadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoService.findById(id);
        return empleado.map(e -> ResponseEntity.ok(new EmpleadoDTO(e))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(empleadoDTO.getIdEmpleado());
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellido1(empleadoDTO.getApellido1());
        empleado.setApellido2(empleadoDTO.getApellido2());
        empleado.setExtension(empleadoDTO.getExtension());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setIdOficina(empleadoDTO.getIdOficina());
        empleado.setJefe(empleadoDTO.getIdJefe() != null ? empleadoService.findById(empleadoDTO.getIdJefe()).orElse(null) : null);
        empleado.setPuesto(empleadoDTO.getIdPuesto() != null ? puestoService.findById(empleadoDTO.getIdPuesto()).orElse(null) : null);

        Empleado nuevoEmpleado = empleadoService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmpleadoDTO(nuevoEmpleado));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        if (empleadoService.findById(id).isPresent()) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(id);
            empleado.setNombre(empleadoDTO.getNombre());
            empleado.setApellido1(empleadoDTO.getApellido1());
            empleado.setApellido2(empleadoDTO.getApellido2());
            empleado.setExtension(empleadoDTO.getExtension());
            empleado.setEmail(empleadoDTO.getEmail());
            empleado.setIdOficina(empleadoDTO.getIdOficina());
            empleado.setJefe(empleadoDTO.getIdJefe() != null ? empleadoService.findById(empleadoDTO.getIdJefe()).orElse(null) : null);
            empleado.setPuesto(empleadoDTO.getIdPuesto() != null ? puestoService.findById(empleadoDTO.getIdPuesto()).orElse(null) : null);

            Empleado empleadoActualizado = empleadoService.update(id, empleado);
            return ResponseEntity.ok(new EmpleadoDTO(empleadoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        if (empleadoService.findById(id).isPresent()) {
            empleadoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}