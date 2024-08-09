package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.springproject.springproject.persistence.entities.Pago;

public class PagoDTO {
    private Long idPago;
    private Long idCliente;
    private Long idFormaPago;
    private LocalDate fechaPago;
    private BigDecimal total;

    public PagoDTO() {
    }

    public PagoDTO(Pago pago) {
        this.idPago = pago.getIdPago();
        this.idCliente = pago.getCliente() != null ? pago.getCliente().getIdCliente() : null;
        this.idFormaPago = pago.getFormaPago() != null ? pago.getFormaPago().getIdFormaPago() : null;
        this.fechaPago = pago.getFechaPago();
        this.total = pago.getTotal();
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Long idFormaPago) {
        this.idFormaPago = idFormaPago;
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
}
