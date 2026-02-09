package com.example.eventsystem.repository;
import com.example.eventsystem.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    // Search by Title
    Page<Event> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    // NEW: Filter by Category
    Page<Event> findByCategory(String category, Pageable pageable);
}