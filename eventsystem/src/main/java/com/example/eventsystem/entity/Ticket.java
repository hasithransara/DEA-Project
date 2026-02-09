package com.example.eventsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String guestName;
    private String guestEmail;

    private int quantity;
    private LocalDateTime bookingDate;

    // --- NEW FIELDS ---
    private String ticketType; // "General", "Gold", or "VIP"
    private Double pricePaid;  // The price at the moment of purchase

    // Empty Constructor (Required by JPA)
    public Ticket() {}

    // Updated Constructor with new fields
    public Ticket(Event event, String guestName, String guestEmail, int quantity, String ticketType, Double pricePaid) {
        this.event = event;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.quantity = quantity;
        this.ticketType = ticketType;
        this.pricePaid = pricePaid;
        this.bookingDate = LocalDateTime.now();
    }

    // --- GETTERS ---
    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public String getGuestName() { return guestName; }
    public String getGuestEmail() { return guestEmail; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public String getTicketType() { return ticketType; }
    public Double getPricePaid() { return pricePaid; }
}