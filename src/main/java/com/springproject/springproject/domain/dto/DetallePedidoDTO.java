package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;

import com.springproject.springproject.persistence.entities.DetallePedido;

public class DetallePedidoDTO {

    private Long idDetallePedido;
    private Long idPedido;
    private Long idProducto;
    private int cantidad;
    private BigDecimal precioUnidad;
    private int numeroLinea;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(DetallePedido detallePedido) {
        this.idDetallePedido = detallePedido.getIdDetallePedido();
        this.idPedido = detallePedido.getPedido() != null ? detallePedido.getPedido().getIdPedido() : null;
        this.idProducto = detallePedido.getProducto() != null ? detallePedido.getProducto().getIdProducto() : null;
        this.cantidad = detallePedido.getCantidad();
        this.precioUnidad = detallePedido.getPrecioUnidad();
        this.numeroLinea = detallePedido.getNumeroLinea();
    }

    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }
}