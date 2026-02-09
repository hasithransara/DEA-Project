package com.example.eventsystem.controller;

import com.example.eventsystem.entity.Event;
import com.example.eventsystem.entity.Ticket;
import com.example.eventsystem.repository.EventRepository;
import com.example.eventsystem.repository.TicketRepository;
import com.example.eventsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired private EventRepository eventRepository;
    @Autowired private TicketRepository ticketRepository;
    @Autowired private EmailService emailService;

    // 1. Show Form (UPDATED: Now accepts 'type' and 'price')
    @GetMapping("/book/{eventId}")
    public String showBookingForm(@PathVariable Long eventId,
                                  @RequestParam String type,   // <--- NEW PARAMETER
                                  @RequestParam Double price,  // <--- NEW PARAMETER
                                  Model model) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        model.addAttribute("event", event);
        model.addAttribute("selectedType", type);   // Pass to HTML
        model.addAttribute("selectedPrice", price); // Pass to HTML
        return "booking-form";
    }

    // 2. Process Booking (UPDATED: Saves 'type' and 'price')
    @PostMapping("/book/process")
    public String processBooking(@RequestParam Long eventId,
                                 @RequestParam String guestName,
                                 @RequestParam String guestEmail,
                                 @RequestParam int quantity,
                                 @RequestParam String ticketType,  // <--- NEW
                                 @RequestParam Double ticketPrice, // <--- NEW
                                 Model model) {

        Event event = eventRepository.findById(eventId).orElseThrow();

        // Save Ticket with Type info
        Ticket ticket = new Ticket(event, guestName, guestEmail, quantity, ticketType, ticketPrice);
        ticketRepository.save(ticket);

        // Send Email with Type info
        emailService.sendEticket(
                guestEmail, guestName,
                event.getTitle() + " (" + ticketType + ")",
                ticket.getId(),
                ticketPrice * quantity
        );

        model.addAttribute("ticket", ticket);
        return "booking-success";
    }
}