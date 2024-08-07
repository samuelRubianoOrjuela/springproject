package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "oficina")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina")
    private Long idOficina;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "linea_direccion1")
    private String lineaDireccion1;

    @Column(name = "linea_direccion2")
    private String lineaDireccion2;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;


    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
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

    // CUIDADO CHICO

    public Ciudad getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    ///////////////

    @Override
    public String toString() {
        return "Oficina{" + "id_oficina='" + idOficina + '\'' + '\'' + ", telefono='" + telefono + '\'' + ", linea_direccion1='" + lineaDireccion1 + '\'' + ", linea_direccion2='" + lineaDireccion2 + '\'' + ", ciudad=" + ciudad +'}';
    }
}
