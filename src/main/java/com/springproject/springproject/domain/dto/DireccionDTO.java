package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Direccion;


public class DireccionDTO {

    private Long idDireccion;
    private Long idCliente;
    private String tipoDireccion;  
    private String direccion;
    private String descripcion;
    private String lineaDireccion1;  
    private String lineaDireccion2; 
    private Long idCiudad;

    public DireccionDTO() {}

    public DireccionDTO(Direccion direccion) {
        this.idDireccion = direccion.getIdDireccion();
        this.idCliente = direccion.getCliente() != null ? direccion.getCliente().getIdCliente() : null;
        this.tipoDireccion = direccion.getTipoDireccion();
        this.direccion = direccion.getDireccion();
        this.descripcion = direccion.getDescripcion();
        this.lineaDireccion1 = direccion.getLineaDireccion1();
        this.lineaDireccion2 = direccion.getLineaDireccion2();
        this.idCiudad = direccion.getCiudad() != null ? direccion.getCiudad().getIdCiudad() : null;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }


    @Override
    public String toString() {
        return "DireccionDTO{" +
               "idDireccion=" + idDireccion +
               ", idCliente=" + idCliente +
               ", tipoDireccion='" + tipoDireccion + '\'' +
               ", direccion='" + direccion + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", lineaDireccion1='" + lineaDireccion1 + '\'' +
               ", lineaDireccion2='" + lineaDireccion2 + '\'' +
               ", idCiudad=" + idCiudad +
               '}';
    }
}