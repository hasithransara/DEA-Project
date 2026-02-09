package com.example.eventsystem.repository;

import com.example.eventsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // We removed "findByUser" because tickets are now for Guests

    // New method: Find tickets by the guest's email
    List<Ticket> findByGuestEmail(String guestEmail);
}