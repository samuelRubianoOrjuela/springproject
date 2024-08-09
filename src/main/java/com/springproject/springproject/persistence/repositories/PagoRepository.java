package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.springproject.persistence.entities.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Pago p SET p.cliente = NULL WHERE p.cliente.idCliente = :id")
    void setClienteNullPago(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Pago p SET p.formaPago = NULL WHERE p.formaPago.id = :idFormaPago")
    void setFormaPagoNull(@Param("idFormaPago") Long idFormaPago);

}
