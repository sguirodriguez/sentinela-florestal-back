package com.sentinela.sentinela_florestal_back.repository;

import com.sentinela.sentinela_florestal_back.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
}

