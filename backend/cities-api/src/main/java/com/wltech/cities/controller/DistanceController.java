package com.wltech.cities.controller;

import com.wltech.cities.service.DistanceService;
import com.wltech.cities.utils.EarthRadius;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/distancies")
public class DistanceController {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceController.class);

    public DistanceController(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }

    @GetMapping("/by-km")
    public ResponseEntity byKm(@RequestParam(name = "from") final Long city1,
                                 @RequestParam(name = "to") final Long city2) {
        return ResponseEntity.ok().body(service.distanceByCubeInKm(city1, city2));
    }

}
