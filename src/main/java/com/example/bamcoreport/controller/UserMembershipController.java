package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.UserMembershipDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserMembership;
import com.example.bamcoreport.services.Impl.IUserMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userMembership")
public class UserMembershipController {

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

}
