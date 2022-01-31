package com.example.bamcoreport.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data @Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column( nullable = false )
    private boolean enabled;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String jobTitle;
    private Long managerUserId;
    private Long createdBy;
    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;






}
