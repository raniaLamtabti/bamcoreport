package com.example.bamcoreport.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;
    @ManyToOne
    @JoinColumn(name = "last_updated_by")
    private User lastUpdatedBy;





}
