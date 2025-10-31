package com.sentinela.sentinela_florestal_back.repository;

import com.sentinela.sentinela_florestal_back.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT DISTINCT e FROM Event e LEFT JOIN FETCH e.images")
    List<Event> findAllWithImages();

    @Query("SELECT DISTINCT e FROM Event e LEFT JOIN FETCH e.images WHERE e.id = :id")
    Optional<Event> findByIdWithImages(@Param("id") Long id);
}
