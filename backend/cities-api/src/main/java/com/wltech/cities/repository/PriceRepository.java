package com.wltech.cities.repository;

import com.wltech.cities.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT valor FROM preco WHERE :km between faixa1 and faixa2 ", nativeQuery = true)
    Double freightPrice(final Double km);


}
