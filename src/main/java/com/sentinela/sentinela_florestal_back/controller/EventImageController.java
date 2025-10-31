package com.sentinela.sentinela_florestal_back.controller;

import com.sentinela.sentinela_florestal_back.entity.EventImage;
import com.sentinela.sentinela_florestal_back.repository.EventImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-images")
@CrossOrigin(origins = "*")
public class EventImageController {
    
    @Autowired
    private EventImageRepository eventImageRepository;
    
    @GetMapping
    public ResponseEntity<List<EventImage>> getAllEventImages() {
        List<EventImage> eventImages = eventImageRepository.findAll();
        return ResponseEntity.ok(eventImages);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EventImage> getEventImageById(@PathVariable Long id) {
        Optional<EventImage> eventImage = eventImageRepository.findById(id);
        return eventImage.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventImage>> getEventImagesByEventId(@PathVariable Long eventId) {
        List<EventImage> eventImages = eventImageRepository.findByEventId(eventId);
        return ResponseEntity.ok(eventImages);
    }
}

