package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;

import com.springproject.springproject.persistence.entities.Dimensiones;


public class DimensionesDTO {

    private Long idDimensiones;
    private BigDecimal ancho;
    private BigDecimal alto;
    private BigDecimal largo;

    public DimensionesDTO() {}

    public DimensionesDTO(Long idDimensiones, BigDecimal ancho, BigDecimal alto, BigDecimal largo) {
        this.idDimensiones = idDimensiones;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;

    }

    public DimensionesDTO(Dimensiones dimensiones){
        this.idDimensiones = dimensiones.getIdDimensiones();
        this.ancho = dimensiones.getAncho();
        this.alto = dimensiones.getAlto();
        this.largo = dimensiones.getLargo();
    }
    

    public Long getIdDimensiones() {
        return idDimensiones;
    }

    public void setIdDimensiones(Long idDimensiones) {
        this.idDimensiones = idDimensiones;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getAlto() {
        return alto;
    }

    public void setAlto(BigDecimal alto) {
        this.alto = alto;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    
}
