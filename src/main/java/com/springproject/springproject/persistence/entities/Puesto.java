package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name="puesto")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuesto;

    @Column(name= "nombre_puesto")
    private String nombrePuesto;

    public Puesto(){}

    public Long getId() {
        return idPuesto;
    }

    public void setId(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    @Override
    public String toString() {
        return "Puesto{id=" + idPuesto + ", nombre_puesto=" + nombrePuesto +"}";
    }
}
