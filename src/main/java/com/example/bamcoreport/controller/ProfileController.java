package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.ProfileDto;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.services.Impl.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    IProfileService profileService;

    @GetMapping("/")
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        List<ProfileDto> profileDto = profileService.getProfiles();
        return ResponseEntity.ok(profileDto);
    }

    @PostMapping
    public void postProfile(@RequestBody Profile profile) {
        profileService.postProfile(profile);
    }
}
