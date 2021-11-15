package com.wltech.cities.controller;

import com.wltech.cities.model.State;
import com.wltech.cities.repository.CountryRepository;
import com.wltech.cities.service.StateService;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/states")
public class StateController {

    private StateService stateService;

    @Autowired
    public StateController(StateService stateService ){
        Assert.noNullElements(new Object[]{stateService},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<State>> getStates(){
        return stateService.getStates();

    }
}
