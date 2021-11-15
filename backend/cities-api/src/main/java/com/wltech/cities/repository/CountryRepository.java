package com.wltech.cities.repository;

import com.wltech.cities.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long > {

}
