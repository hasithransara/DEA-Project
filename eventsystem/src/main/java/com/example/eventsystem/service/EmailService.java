package com.example.eventsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNotification(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@eventsystem.com"); // This can be anything
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Email sent to Mailtrap!"); // Console log for debugging
    }
    public void sendEticket(String to, String userName, String eventTitle, Long ticketId, Double price) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your E-Ticket for: " + eventTitle);

        // A simple text-based E-Ticket design
        String ticketBody = String.format("""
            Dear %s,
            
            Thank you for your purchase! Here is your E-Ticket.
            
            ------------------------------------------------
            EVENT TICKET #%d
            ------------------------------------------------
            Event:  %s
            Price:  $%.2f
            Status: PAID
            ------------------------------------------------
            
            Please show this email at the entrance.
            
            Enjoy the event!
            EventHub Team
            """, userName, ticketId, eventTitle, price);

        message.setText(ticketBody);
        mailSender.send(message);
    }
}