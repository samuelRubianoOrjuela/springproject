// package com.springproject.springproject.persistence.entities;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.Column;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;

// @Entity
// @Table(name = "stock")
// public class Stock {

//     @Id
//     @Column(name = "id_stock")
//     private Long idStock;

//     @ManyToOne
//     @JoinColumn(name = "id_producto")
//     private Producto producto;

//     @Column(name = "cantidad_en_stock")
//     private int cantidadEnStock;

//     public Stock() {
//     }

//     public Long getIdStock() {
//         return idStock;
//     }

//     public void setIdStock(Long idStock) {
//         this.idStock = idStock;
//     }

//     public Producto getProducto() {
//         return producto;
//     }

//     public void setProducto(Producto producto) {
//         this.producto = producto;
//     }

//     public int getCantidadEnStock() {
//         return cantidadEnStock;
//     }

//     public void setCantidadEnStock(int cantidadEnStock) {
//         this.cantidadEnStock = cantidadEnStock;
//     }

//     @Override
//     public String toString() {
//         return "Stock{" +
//                "id_stock=" + idStock +
//                ", producto=" + (producto != null ? producto.getIdProducto() : "null") +
//                ", cantidad_en_stock=" + cantidadEnStock +
//                '}';
//     }
// }

