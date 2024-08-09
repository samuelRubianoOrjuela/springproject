package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;

import com.springproject.springproject.persistence.entities.Producto;

public class ProductoDTO {
    
    private Long idProducto;
    private String nombre;
    private String gama;
    private Long idDimensiones;
    private Long idProveedor;
    private String descripcion;
    private Short cantidadEnStock;
    private BigDecimal precioVenta;
    private BigDecimal precioProveedor;


    public ProductoDTO(){}

    public ProductoDTO(Producto producto){
        this.idProducto = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.gama = producto.getGamaProducto() != null ? producto.getGamaProducto().getGama() : null;
        this.idDimensiones = producto.getDimensiones() != null ? producto.getDimensiones().getIdDimensiones() : null;
        this.idProveedor = producto.getProveedor() != null ? producto.getProveedor().getIdProveedor() : null;
        this.descripcion = producto.getDescripcion();
        this.cantidadEnStock = producto.getCantidadEnStock();
        this.precioVenta = producto.getPrecioVenta();
        this.precioProveedor = producto.getPrecioProveedor();
    }


    public Long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGama() {
        return gama;
    }
    public void setGama(String gama) {
        this.gama = gama;
    }
    public Long getIdDimensiones() {
        return idDimensiones;
    }
    public void setIdDimensiones(Long idDimensiones) {
        this.idDimensiones = idDimensiones;
    }
    public Long getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Short getCantidadEnStock() {
        return cantidadEnStock;
    }
    public void setCantidadEnStock(Short cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    public BigDecimal getPrecioProveedor() {
        return precioProveedor;
    }
    public void setPrecioProveedor(BigDecimal precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    
}