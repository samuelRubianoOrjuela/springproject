package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Pais;

public class PaisDTO {

    private Long idPais;
    private String nombrePais;

    
    public PaisDTO() {
    }

    
    public PaisDTO(Long idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }

    
    public PaisDTO(Pais pais) {
        this.idPais = pais.getIdPais();
        this.nombrePais = pais.getNombrePais();
    }

    
    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}


