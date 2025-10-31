package com.sentinela.sentinela_florestal_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "city_halls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityHall {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, length = 255)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String mayor;
    
    @Column(length = 20)
    private String phoneNumber;
    
    @Column(length = 255)
    private String logoName;
    
    @Column(nullable = false, length = 100)
    private String street;
    
    @Column(nullable = false, length = 100)
    private String neighborhood;
    
    @Column(nullable = false, length = 100)
    private String city;
    
    @Column(nullable = false, length = 2)
    private String state;
    
    @Column(nullable = false, length = 10)
    private String zipcode;
    
    @Column(nullable = false, length = 15)
    private String addressNumber;
    
    @Column(length = 100)
    private String complement;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

