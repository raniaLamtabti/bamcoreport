package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.UserMembershipDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.UserMembership;
import com.example.bamcoreport.repositories.UserMembershipRepository;
import com.example.bamcoreport.services.Impl.IUserMembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserMembershipService implements IUserMembershipService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

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

    @Override
    public void deleteUserMembership(Long userMembershipId) {
        boolean exists =  userMembershipRepository.existsById(userMembershipId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        userMembershipRepository.deleteById(userMembershipId);
    }

}
