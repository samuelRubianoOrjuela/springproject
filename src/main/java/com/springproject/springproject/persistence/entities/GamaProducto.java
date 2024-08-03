package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "gama_producto")
public class GamaProducto {

    @Id
    @Column(name = "gama")
    private String gama;

    @Column(name = "descripcion_texto")
    private String descripcionTexto;

    @Column(name = "descripcion_html")
    private String descripcionHtml;

    @Column(name = "imagen")
    private String imagen;

    public GamaProducto() {
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

    @Override
    public String toString() {
        return "GamaProducto{" + "gama='" + gama + '\'' + ", descripcion_texto='" + descripcionTexto + '\'' + ", descripcion_html='" + descripcionHtml + '\'' + ", imagen='" + imagen + '\'' + '}';
    }
}
