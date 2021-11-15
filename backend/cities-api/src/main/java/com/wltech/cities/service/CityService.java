package com.wltech.cities.service;

import com.wltech.cities.model.City;
import com.wltech.cities.model.Country;
import com.wltech.cities.model.State;
import com.wltech.cities.repository.CityRepository;
import com.wltech.cities.repository.StateRepository;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CityService {


    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        Assert.noNullElements(new Object[]{cityRepository},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.cityRepository = cityRepository;
    }

    @Transactional
    public ResponseEntity<List<City>> getCities(){
        List<City> lista = cityRepository.findAll();
        if (lista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @Transactional(readOnly = true)
    public Page<City> getCitiesPage(Pageable page){

        return cityRepository.findAll(page);
    }


}
