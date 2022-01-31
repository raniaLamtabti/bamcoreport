package com.example.bamcoreport.dto.model;

import com.example.bamcoreport.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GroupDto {
    private String name;
    private String parentPath;
    private String displayName;
    private String description;
    private User createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
}
