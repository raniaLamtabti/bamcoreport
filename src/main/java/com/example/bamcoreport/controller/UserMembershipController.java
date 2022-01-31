package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.UserMembershipDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserMembership;
import com.example.bamcoreport.services.Impl.IUserMembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userMembership")
public class UserMembershipController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserMembershipService userMembershipService;

    @GetMapping("/")
    public ResponseEntity<List<UserMembershipDto>> getAllUserMemberships(){
        List<UserMembershipDto> userMembershipDto = userMembershipService.getUserMemberships();
        return ResponseEntity.ok(userMembershipDto);
    }

    @PostMapping
    public void postUserMembership(@RequestBody UserMembership userMembership) {
        userMembershipService.postUserMembership(userMembership);
    }

    @DeleteMapping(path = "{userMembershipId}")
    public void deleteUserMembership(@PathVariable("userMembershipId") Long userMembershipId){
        log.warn("user deleted");
        userMembershipService.deleteUserMembership(userMembershipId);
    }

}
