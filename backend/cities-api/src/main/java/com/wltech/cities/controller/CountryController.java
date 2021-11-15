package com.wltech.cities.controller;

import com.wltech.cities.model.Country;
import com.wltech.cities.repository.CountryRepository;
import com.wltech.cities.service.CountryService;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService ){
        Assert.noNullElements(new Object[]{countryService}, Constants.FALHA_INJECAO_DEPENDENCIA);
        this.countryService = countryService;
    }


    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryService.getCountriesPage(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){
        return countryService.getCountry(id);
    }

}
