package com.example.eventsystem;

import com.example.eventsystem.entity.Event;
import com.example.eventsystem.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EventSystemApplicationTests {

    @Autowired
    private EventRepository eventRepository;

    @Test
    void testCreateEvent() {
        // 1. Create a dummy event
        Event event = new Event();
        event.setTitle("Test Concert");
        event.setDescription("This is a test description");
        event.setVenue("Test Venue");
        event.setCategory("Concerts");
        event.setPriceGeneral(50.0);

        // 2. Save it to the database
        Event savedEvent = eventRepository.save(event);

        // 3. Assert (Check) that it was saved correctly
        assertThat(savedEvent.getId()).isNotNull(); // It should have an ID now
        assertThat(savedEvent.getTitle()).isEqualTo("Test Concert");
    }

    @Test
    void contextLoads() {
        // Simple sanity check to ensure the app starts up
        assertThat(eventRepository).isNotNull();
    }
}