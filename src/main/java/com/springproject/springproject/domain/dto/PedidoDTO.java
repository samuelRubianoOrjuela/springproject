package com.springproject.springproject.domain.dto;

import java.time.LocalDate;

import com.springproject.springproject.persistence.entities.Pedido;


public class PedidoDTO {

    private Long idPedido;
    private LocalDate fechaPedido;
    private LocalDate fechaEsperada;
    private LocalDate fechaEntrega;
    private String comentarios;
    private Long idCliente; 
    private String metodoPago;
    private Long idPago; 
    private Long idEstadoPedido; 


    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido){
        this.idPedido = pedido.getIdPedido();
        this.fechaPedido = pedido.getFechaPedido();
        this.fechaEsperada = pedido.getFechaEsperada();
        this.fechaEntrega = pedido.getFechaEntrega();
        this.comentarios = pedido.getComentarios();
        this.metodoPago = pedido.getMetodoPago();
        this.idCliente = pedido.getCliente() != null ? pedido.getCliente().getIdCliente() : null;
        this.idPago = pedido.getPago() != null ? pedido.getPago().getIdPago() : null;
        this.idEstadoPedido = pedido.getEstadoPedido() != null ? pedido.getEstadoPedido().getIdEstado() : null;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDate fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Long idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }
}