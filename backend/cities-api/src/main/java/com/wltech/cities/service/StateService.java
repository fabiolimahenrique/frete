package com.wltech.cities.service;

import com.wltech.cities.model.State;
import com.wltech.cities.repository.CountryRepository;
import com.wltech.cities.repository.StateRepository;
import com.wltech.cities.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StateService {

    private StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository){
        Assert.noNullElements(new Object[]{stateRepository},
                Constants.FALHA_INJECAO_DEPENDENCIA);
        this.stateRepository = stateRepository;
    }

    @Transactional
    public ResponseEntity<List<State>> getStates(){
        List<State> lista = stateRepository.findAll();
        if (lista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

}
