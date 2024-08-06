package com.springproject.springproject.domain.dto;

import java.math.BigDecimal;

import com.springproject.springproject.persistence.entities.Cliente;


public class ClienteDTO {

    private Long idCliente;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String fax;
    private String telefono;
    private Long ciudadId;
    private Long direccionId;
    private Long empleadoRepVentasId;
    private BigDecimal limiteCredito;
    private Cliente cliente;
    

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getApellidoContacto() {
        return apellidoContacto;
    }
    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    //Constructor
    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nombreCliente = cliente.getNombreCliente();
        this.nombreContacto = cliente.getNombreContacto();
        this.apellidoContacto = cliente.getApellidoContacto();
        this.fax = cliente.getFax();
        this.telefono = cliente.getTelefono();
        this.ciudadId = cliente.getCiudad() != null ? cliente.getCiudad().getIdCiudad() : null;
        this.direccionId = cliente.getDireccion() != null ? cliente.getDireccion().getIdDireccion() : null;
        this.empleadoRepVentasId = cliente.getEmpleadoRepVentas() != null ? cliente.getEmpleadoRepVentas().getIdEmpleado() : null;
        this.limiteCredito = cliente.getLimiteCredito();
    }


}
