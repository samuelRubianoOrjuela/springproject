package com.springproject.springproject.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.persistence.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
