package com.springproject.springproject.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    private Direccion direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado_rep_ventas", referencedColumnName = "id_empleado")
    private Empleado empleadoRepVentas;

    @Column(name = "limite_credito")
    private BigDecimal limiteCredito;

    public Cliente() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreContacto(){
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empleado getEmpleadoRepVentas() {
        return empleadoRepVentas;
    }

    public void setEmpleadoRepVentas(Empleado empleadoRepVentas) {
        this.empleadoRepVentas = empleadoRepVentas;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    // @Override
    // public String toString() {
    //     return "Cliente{" +
    //            "id_cliente=" + idCliente +
    //            ", nombre_cliente='" + nombreCliente + '\'' +
    //            ", nombre_Cliente='" + nombreCliente + '\'' +
    //            ", apellido_Cliente='" + apellidoCliente + '\'' +
    //            ", fax='" + fax + '\'' +
    //            ", telefono='" + telefono + '\'' +
    //            ", ciudad=" + (ciudad != null ? ciudad.getIdCiudad() : null) +
    //            ", direccion=" + (direccion != null ? direccion.getIdDireccion() : null) +
    //            ", empleadoRepVentas=" + (empleadoRepVentas != null ? empleadoRepVentas.getIdEmpleado() : null) +
    //            ", limite_credito=" + limiteCredito +
    //            '}';
    // }
}

