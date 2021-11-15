package com.wltech.cities.controller;

import com.wltech.cities.model.City;
import com.wltech.cities.model.Country;
import com.wltech.cities.service.CityService;
import com.wltech.cities.service.CountryService;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cities")
public class CityController {


    private CityService cityService;

    @Autowired
    public CityController(CityService cityService ){
        Assert.noNullElements(new Object[]{cityService}, Constants.FALHA_INJECAO_DEPENDENCIA);
        this.cityService = cityService;
    }

    @GetMapping
    public Page<City> citiesPage(Pageable page) {
        return cityService.getCitiesPage(page);
    }


}
