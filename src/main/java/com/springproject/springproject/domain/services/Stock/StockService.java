package com.springproject.springproject.domain.services.Stock;

import java.util.List;
import java.util.Optional;

import com.springproject.springproject.persistence.entities.Stock;

public interface StockService {

    List<Stock> findAll();
    Optional<Stock> findById(Long id);
    Stock save(Stock stock);
    Stock update(Long id, Stock stock);
    Optional<Stock> delete(Long id);
    
}
