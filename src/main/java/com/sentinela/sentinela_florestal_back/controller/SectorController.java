package com.sentinela.sentinela_florestal_back.controller;

import com.sentinela.sentinela_florestal_back.entity.Sector;
import com.sentinela.sentinela_florestal_back.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sectors")
@CrossOrigin(origins = "*")
public class SectorController {
    
    @Autowired
    private SectorRepository sectorRepository;
    
    @GetMapping
    public ResponseEntity<List<Sector>> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        return ResponseEntity.ok(sectors);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        Optional<Sector> sector = sectorRepository.findById(id);
        return sector.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

