package com.example.bamcoreport.dto.model;


import com.example.bamcoreport.entities.*;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class UserMembershipDto {

    private User userId;
    private Role roleId;
    private Group groupId;
    private User assignedBy;
    private LocalDateTime assigned_date;
}
