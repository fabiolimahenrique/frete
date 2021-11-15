package com.wltech.cities.service;

import com.wltech.cities.model.City;
import com.wltech.cities.model.FreteDTO;
import com.wltech.cities.model.Price;
import com.wltech.cities.repository.CityRepository;
import com.wltech.cities.repository.PriceRepository;
import com.wltech.cities.repository.StateRepository;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceService {

    private PriceRepository priceRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository){
        Assert.noNullElements(new Object[]{priceRepository},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.priceRepository = priceRepository;
    }

    @Transactional(readOnly = true)
    public Double getFreightPrice(Double km){
        return priceRepository.freightPrice(km);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Price>> getPrice(){
        return ResponseEntity.ok( priceRepository.findAll() );
    }

    public List<FreteDTO> GetFreight(FreteDTO freteRQ ){
        FreteDTO frete = new FreteDTO();
        City cityOrigin = cityRepository.findByName(freteRQ.getOrigem());
        City cityDestin = cityRepository.findByName(freteRQ.getDestino());

        final List<City> cities = cityRepository.findAllById((Arrays.asList(cityOrigin.getId(), cityDestin.getId() )));
        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();
        Double km = cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY()) / 1000;

        frete.setOrigem(freteRQ.getOrigem());
        frete.setDestino(freteRQ.getDestino());
        frete.setKm(km);
        frete.setValor( getFreightPrice(km) );

        List<FreteDTO> lista = new ArrayList<FreteDTO>();
        lista.add(frete);
        return lista;
    }

}
