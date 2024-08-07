package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Empleado;

public class EmpleadoDTO {

    private Long idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private Long idOficina;
    private Long idJefe;  
    private Long idPuesto; 

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Empleado empleado) {
        this.idEmpleado = empleado.getIdEmpleado();
        this.nombre = empleado.getNombre();
        this.apellido1 = empleado.getApellido1();
        this.apellido2 = empleado.getApellido2();
        this.extension = empleado.getExtension();
        this.email = empleado.getEmail();
        this.idOficina = empleado.getOficina() != null ? empleado.getOficina().getIdOficina() : null;
        this.idJefe = empleado.getJefe() != null ? empleado.getJefe().getIdEmpleado() : null;
        this.idPuesto = empleado.getPuesto() != null ? empleado.getPuesto().getIdPuesto() : null;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }

    public Long getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(Long idJefe) {
        this.idJefe = idJefe;
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }
}
