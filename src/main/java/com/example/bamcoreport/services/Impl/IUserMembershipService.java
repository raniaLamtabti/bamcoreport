package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.UserMembershipDto;
import com.example.bamcoreport.entities.UserMembership;

import java.util.List;

public interface IUserMembershipService {

    List<UserMembershipDto> getUserMemberships();
    void postUserMembership(UserMembership userMembership);
    void deleteUserMembership(Long userMembershipId);
}
