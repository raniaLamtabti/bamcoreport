package com.example.bamcoreport.dto.model;

import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserContactInfo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private UserContactInfo userContactInfo;
    private boolean enabled;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobTitle;
    private User managerUserId;
    private User createdBy;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;


}
