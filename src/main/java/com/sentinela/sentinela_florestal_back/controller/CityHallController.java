package com.sentinela.sentinela_florestal_back.controller;

import com.sentinela.sentinela_florestal_back.entity.CityHall;
import com.sentinela.sentinela_florestal_back.repository.CityHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city-halls")
@CrossOrigin(origins = "*")
public class CityHallController {
    
    @Autowired
    private CityHallRepository cityHallRepository;
    
    @GetMapping
    public ResponseEntity<List<CityHall>> getAllCityHalls() {
        List<CityHall> cityHalls = cityHallRepository.findAll();
        return ResponseEntity.ok(cityHalls);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CityHall> getCityHallById(@PathVariable Long id) {
        Optional<CityHall> cityHall = cityHallRepository.findById(id);
        return cityHall.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

