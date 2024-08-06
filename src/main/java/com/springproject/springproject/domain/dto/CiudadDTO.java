package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Ciudad;

public class CiudadDTO {

    private Long idCiudad;
    private String nombreCiudad;
    private String codigoPostal;
    private Long idPais;

    
    public CiudadDTO() {
    }


    public CiudadDTO(Ciudad ciudad) {
        this.idCiudad = ciudad.getIdCiudad();
        this.nombreCiudad = ciudad.getNombreCiudad();
        this.codigoPostal = ciudad.getCodigoPostal();
        this.idPais = ciudad.getPais() != null ? ciudad.getPais().getIdPais() : null;
    }

    
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }


    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}

