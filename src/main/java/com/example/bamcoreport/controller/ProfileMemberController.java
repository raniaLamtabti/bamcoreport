package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.ProfileMemberDto;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.entities.ProfileMember;
import com.example.bamcoreport.services.Impl.IProfileMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profileMember")
public class ProfileMemberController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IProfileMemberService profileMemberService;

    @GetMapping("/")
    public ResponseEntity<List<ProfileMemberDto>> getAllProfileMembers(){
        List<ProfileMemberDto> profileMemberDto = profileMemberService.getProfileMembers();
        return ResponseEntity.ok(profileMemberDto);
    }

    @PostMapping
    public void postProfileMember(@RequestBody ProfileMember profileMember) {
        profileMemberService.postProfileMember(profileMember);
    }

    @DeleteMapping(path = "{profileId}")
    public void deleteProfileMember(@PathVariable("profileMemberId") Long profileMemberId){
        log.warn("profile member deleted");
        profileMemberService.deleteProfileMember(profileMemberId);
    }
}
