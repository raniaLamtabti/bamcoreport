package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.ProfileDto;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.services.Impl.IProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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

    @DeleteMapping(path = "{profileId}")
    public void deleteProfile(@PathVariable("profileId") Long profileId){
        log.warn("profile deleted");
        profileService.deleteProfile(profileId);
    }
}
