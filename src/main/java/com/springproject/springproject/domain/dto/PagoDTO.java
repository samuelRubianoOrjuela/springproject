package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.springproject.springproject.persistence.entities.Cliente;
import com.springproject.springproject.persistence.entities.FormaPago;
import com.springproject.springproject.persistence.entities.Pago;

public class PagoDTO {
    private Long idPago;
    private Cliente cliente;
    private FormaPago formaPago;
    private LocalDate fechaPago;
    private BigDecimal total;
    private Pago pago;

    public Long getIdPago() {
        return idPago;
    }
    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public LocalDate getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Pago getPago() {
        return pago;
    }
    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public PagoDTO(Pago pago) {
        this.idPago = pago.getIdPago();
        this.cliente = pago.getCliente();
        this.formaPago = pago.getFormaPago();
        this.fechaPago = pago.getFechaPago();
        this.total = pago.getTotal();
    }

    

}
