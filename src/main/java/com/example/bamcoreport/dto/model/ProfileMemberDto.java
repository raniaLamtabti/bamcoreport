package com.example.bamcoreport.dto.model;

import com.example.bamcoreport.entities.Group;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.entities.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProfileMemberDto {

    private Profile profileId;
    private User userId;
    private Role roleId;
    private Group groupId;
}
