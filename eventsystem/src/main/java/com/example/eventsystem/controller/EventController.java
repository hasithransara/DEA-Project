package com.example.eventsystem.controller;

import com.example.eventsystem.entity.Event;
import com.example.eventsystem.repository.EventRepository;
import com.example.eventsystem.service.EmailService;
import com.example.eventsystem.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.security.Principal;

@Controller
public class EventController {

    @Autowired private EventRepository eventRepository;
    @Autowired private FileStorageService storageService;
    @Autowired private EmailService emailService;

    // 1. PUBLIC HOME PAGE (Updated with Category Filter)
    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(required = false) String category) { // <--- New Param

        Pageable pageable = PageRequest.of(page, 9, Sort.by("id").descending());
        Page<Event> events;

        if (category != null && !category.isEmpty()) {
            // If category is selected, ignore keyword and show only that category
            events = eventRepository.findByCategory(category, pageable);
        } else if (keyword != null && !keyword.isEmpty()) {
            // If searching, filter by keyword
            events = eventRepository.findByTitleContainingIgnoreCase(keyword, pageable);
        } else {
            // Otherwise show all
            events = eventRepository.findAll(pageable);
        }

        model.addAttribute("events", events);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category); // Pass back to UI to keep link active
        return "home";
    }

    // 2. EVENT DETAILS (Public)
    @GetMapping("/event/{id}")
    public String viewEvent(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow();
        model.addAttribute("event", event);
        return "event-details";
    }

    // 3. ADMIN DASHBOARD
    @GetMapping("/events")
    public String manageEvents(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Event> events = eventRepository.findByTitleContainingIgnoreCase(keyword, pageable);
        model.addAttribute("events", events);
        model.addAttribute("keyword", keyword);
        return "event-list";
    }

    @GetMapping("/events/new")
    public String showForm(Model model) {
        model.addAttribute("event", new Event());
        return "event-form";
    }

    @GetMapping("/events/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow();
        model.addAttribute("event", event);
        return "event-form";
    }

    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute Event event,
                            @RequestParam("image") MultipartFile file,
                            Principal principal) {
        // Check if new BEFORE saving
        boolean isNew = (event.getId() == null);

        if (!file.isEmpty()) {
            event.setImageFileName(storageService.save(file));
        }
        eventRepository.save(event);

        if(isNew) {
            emailService.sendNotification(principal.getName(), "Event Created", "You created: " + event.getTitle());
        }
        return "redirect:/events";
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }
    @GetMapping("/test")
    @ResponseBody
    public String testPage() {
        return "System is working!";
    }
}