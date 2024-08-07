package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;
import com.springproject.springproject.persistence.entities.Cliente;

public class ClienteDTO {

    private Long idCliente;
    private String nombreContacto;
    private String nombreCliente;
    private String apellidoCliente;
    private String email;
    private String fax;
    private String telefono;
    private Long ciudadId;
    private Long direccionId;
    private Long empleadoRepVentasId;
    private BigDecimal limiteCredito;

    public ClienteDTO() {
    }

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getCiudadId() {
        return ciudadId;
    }
    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Long getDireccionId() {
        return direccionId;
    }
    public void setDireccionId(Long direccionId) {
        this.direccionId = direccionId;
    }

    public Long getEmpleadoRepVentasId() {
        return empleadoRepVentasId;
    }
    public void setEmpleadoRepVentasId(Long empleadoRepVentasId) {
        this.empleadoRepVentasId = empleadoRepVentasId;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public ClienteDTO(Cliente cliente) {
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nombreContacto = cliente.getNombreContacto();
            this.nombreCliente = cliente.getNombreCliente();
            this.apellidoCliente = cliente.getApellidoCliente();
            this.email = cliente.getEmail();
            this.fax = cliente.getFax();
            this.telefono = cliente.getTelefono();
            this.ciudadId = cliente.getCiudad() != null ? cliente.getCiudad().getIdCiudad() : null;
            this.direccionId = cliente.getDireccion() != null ? cliente.getDireccion().getIdDireccion() : null;
            this.empleadoRepVentasId = cliente.getEmpleadoRepVentas() != null ? cliente.getEmpleadoRepVentas().getIdEmpleado() : null;
            this.limiteCredito = cliente.getLimiteCredito();
        }
    }
}


