package com.wltech.cities.service;

import com.wltech.cities.model.Country;
import com.wltech.cities.repository.CountryRepository;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository ){
        Assert.noNullElements(new Object[]{countryRepository},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Country> getCountry(Long id){
        Optional<Country> optCountry = countryRepository.findById(id);
        if (optCountry.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optCountry.get());
    }

    @Transactional(readOnly = true)
    public Page<Country> getCountriesPage(Pageable page){
        return countryRepository.findAll(page);
    }

}
