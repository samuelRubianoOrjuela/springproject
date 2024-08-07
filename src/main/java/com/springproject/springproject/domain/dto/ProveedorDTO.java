package com.springproject.springproject.domain.dto;

import com.springproject.springproject.persistence.entities.Proveedor;

public class ProveedorDTO {
    
    private Long idProveedor;
    private String nombre;
    private Long idCiudad;

    public ProveedorDTO(){}

        public ProveedorDTO(Proveedor proveedor) {
        this.idProveedor = proveedor.getIdProveedor();
        this.nombre = proveedor.getNombre();
        this.idCiudad = proveedor.getCiudad() != null ? proveedor.getCiudad().getIdCiudad() : null;
    }

        public Long getIdProveedor() {
            return idProveedor;
        }

        public void setIdProveedor(Long idProveedor) {
            this.idProveedor = idProveedor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Long getIdCiudad() {
            return idCiudad;
        }

        public void setIdCiudad(Long idCiudad) {
            this.idCiudad = idCiudad;
        }

    
}