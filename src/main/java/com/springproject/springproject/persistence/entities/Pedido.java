package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "fecha_esperada")
    private LocalDate fechaEsperada;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPedido estadoPedido;

    public Pedido() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
               "id_pedido=" + idPedido +
               ", fecha_pedido=" + fechaPedido +
               ", fecha_esperada=" + fechaEsperada +
               ", fecha_entrega=" + fechaEntrega +
               ", comentarios='" + comentarios + '\'' +
               ", cliente=" + (cliente != null ? cliente.getIdCliente() : "null") +
               ", metodo_pago='" + metodoPago + '\'' +
               ", pago=" + (pago != null ? pago.getIdPago() : "null") +
               ", estado_pedido=" + (estadoPedido != null ? estadoPedido.getIdEstado() : "null") +
               '}';
    }
}
