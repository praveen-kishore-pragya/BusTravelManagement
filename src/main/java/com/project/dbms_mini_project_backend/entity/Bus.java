package com.project.dbms_mini_project_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String route;
    @Column(name = "departure_time")
    private String departureTime; // New field

    @Column(name = "arrival_time")
    private String arrivalTime;   // New field
    private String status;    // New field

    // Getters and setters
}

