package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.FormaPago;

public class FormaPagoDTO {

    private Long idFormaPago;
    private String nombreFormaPago;

    public FormaPagoDTO() {
    }

    public FormaPagoDTO(FormaPago formaPago) {
        this.idFormaPago = formaPago.getIdFormaPago();
        this.nombreFormaPago = formaPago.getNombreFormaPago();
    }

    public Long getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Long idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }
}