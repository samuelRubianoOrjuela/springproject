package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedido {

    @Id
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    public EstadoPedido() {
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" +
               "id_estado=" + idEstado +
               ", nombre_estado='" + nombreEstado + '\'' +
               '}';
    }
}
