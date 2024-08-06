package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Oficina;

public class OficinaDTO {
    private Long idOficina;
    private Long idCiudad;
    private String telefono; 
    private String lineaDireccion1;
    private String lineaDireccion2;

    
    public OficinaDTO() {
    }

    public OficinaDTO(Oficina oficina) {
        this.idOficina = oficina.getIdOficina();
        this.idCiudad = oficina.getCiudad() != null ? oficina.getCiudad().getIdCiudad() : null;
        this.telefono = oficina.getTelefono();
        this.lineaDireccion1 = oficina.getLineaDireccion1();
        this.lineaDireccion2 = oficina.getLineaDireccion2();
    }


    public Long getIdOficina() {
        return idOficina;
    }


    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }


    public Long getIdCiudad() {
        return idCiudad;
    }


    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    


    
}
