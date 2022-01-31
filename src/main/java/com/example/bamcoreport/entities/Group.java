package com.example.bamcoreport.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name ="groups")
public class Group {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String parentPath;
    private String displayName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by" ,referencedColumnName = "id")
    private User createdBy;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;




}
