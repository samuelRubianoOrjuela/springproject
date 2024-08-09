package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.EstadoPedido;

public class EstadoPedidoDTO {

    private Long idEstado;
    private String nombreEstado;

    public EstadoPedidoDTO(){}

    public EstadoPedidoDTO(EstadoPedido estadoPedido){
        this.idEstado = estadoPedido.getIdEstado();
        this.nombreEstado = estadoPedido.getNombreEstado();
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

    
}