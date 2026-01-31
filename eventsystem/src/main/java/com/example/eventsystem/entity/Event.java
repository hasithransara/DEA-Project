package com.example.eventsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(length = 1000)
    private String description;

    private String imageFileName;
    private String venue;
    private LocalTime startTime;

    // NEW FIELD
    private String category;

    private Double priceGeneral;
    private Double priceGold;
    private Double priceVip;

    // --- GETTERS AND SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageFileName() { return imageFileName; }
    public void setImageFileName(String imageFileName) { this.imageFileName = imageFileName; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getPriceGeneral() { return priceGeneral; }
    public void setPriceGeneral(Double priceGeneral) { this.priceGeneral = priceGeneral; }
    public Double getPriceGold() { return priceGold; }
    public void setPriceGold(Double priceGold) { this.priceGold = priceGold; }
    public Double getPriceVip() { return priceVip; }
    public void setPriceVip(Double priceVip) { this.priceVip = priceVip; }
}