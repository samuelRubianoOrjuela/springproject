package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.Column;



@Entity
@Table(name = "dimensiones")
public class Dimensiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dimensiones")
    private Long idDimensiones;

    @Column(name = "ancho")
    private BigDecimal ancho;

    @Column(name = "alto")
    private BigDecimal alto;

    @Column(name = "largo")
    private BigDecimal largo;


    public Dimensiones() {
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

    @Override
    public String toString() {
        return "Dimensiones{" + "id_dimensiones=" + idDimensiones + ", ancho=" + ancho + ", alto=" + alto + ", largo=" + largo + '}';
    }
}
