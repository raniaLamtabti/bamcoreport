package com.example.bamcoreport.dto.model;

import com.example.bamcoreport.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContactInfoDto {

    @JsonIgnore
    private User userId;
    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private String building;
    private String room;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String website;
    private boolean personal;


}
