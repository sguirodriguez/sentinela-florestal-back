package com.sentinela.sentinela_florestal_back.repository;

import com.sentinela.sentinela_florestal_back.entity.CityHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityHallRepository extends JpaRepository<CityHall, Long> {
}

