package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.GamaProducto;

public class GamaProductoDTO {
    
    private String gama;
    private String descripcionTexto;
    private String descripcionHtml;
    private String imagen;

    public GamaProductoDTO() {}

    public GamaProductoDTO(GamaProducto gamaProducto) {
        this.gama = gamaProducto.getGama();
        this.descripcionTexto = gamaProducto.getDescripcionTexto();
        this.descripcionHtml = gamaProducto.getDescripcionHtml();
        this.imagen = gamaProducto.getImagen();
    
    }
    
    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

}