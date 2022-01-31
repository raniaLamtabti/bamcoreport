package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.UserMembershipDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserMembership;
import com.example.bamcoreport.repositories.UserMembershipRepository;
import com.example.bamcoreport.services.Impl.IUserMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMembershipService implements IUserMembershipService {

    @Autowired
    UserMembershipRepository userMembershipRepository;

    @Autowired
    IMapClassWithDto<UserMembership, UserMembershipDto> UserMembershipMapping;

    @Override
    public List<UserMembershipDto> getUserMemberships() {
        List<UserMembership> UserMemberships = userMembershipRepository.findAll();
        return UserMembershipMapping.convertListToListDto(UserMemberships,UserMembershipDto.class);
    }

    public void postUserMembership(UserMembership userMembership) {
        userMembershipRepository.save(userMembership);
    }

}
