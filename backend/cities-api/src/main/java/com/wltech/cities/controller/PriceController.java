package com.wltech.cities.controller;

import com.wltech.cities.model.FreteDTO;
import com.wltech.cities.service.PriceService;
import com.wltech.cities.service.StateService;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/price")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService ){
        Assert.noNullElements(new Object[]{priceService},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity getPrice(){
        return priceService.getPrice();
    }

    @GetMapping("/{km}")
    public ResponseEntity getFreightPrice(@PathVariable Double km){
        return ResponseEntity.ok().body(priceService.getFreightPrice(km));
    }

    @PostMapping("/freight")
    public ResponseEntity GetFreight(@RequestBody FreteDTO freteDTO ) {
        return ResponseEntity.ok().body( priceService.GetFreight(freteDTO));
    }
}
