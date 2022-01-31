package com.example.bamcoreport.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMembership {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;
    @ManyToOne
    @JoinColumn(name = "assigned_by")
    private User assignedBy;
    @CreationTimestamp
    private LocalDate assigned_date;



}
