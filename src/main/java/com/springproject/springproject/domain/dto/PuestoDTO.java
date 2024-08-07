package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Puesto;

public class PuestoDTO {

    private Long idPuesto;
    private String nombrePuesto;

    public PuestoDTO() {}

    
    public Long getIdPuesto() {
        return idPuesto;
    }
    
    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }
    
    public String getNombrePuesto() {
        return nombrePuesto;
    }
    
    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }
    
    public PuestoDTO(Puesto puesto) {
        this.idPuesto = puesto.getIdPuesto();
    this.nombrePuesto = puesto.getNombrePuesto();
    }
    
}
