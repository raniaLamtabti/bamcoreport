package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.UserContactInfoDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserContactInfo;
import com.example.bamcoreport.services.Impl.IUserContactInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactUser")
public class UserContactInfoController {

    private static final Logger log = LoggerFactory.getLogger(UserContactInfoController.class);

    @Autowired
    IUserContactInfoService userContactInfoService;

    @GetMapping("/")
    public ResponseEntity<List<UserContactInfoDto>> getAllUsersContactInfo(){
        List<UserContactInfoDto> userContactInfoDto = userContactInfoService.getUsersContactInfo();
        return ResponseEntity.ok(userContactInfoDto);
    }

    @PostMapping
    public void postUserContactInfo(@RequestBody UserContactInfo userContactInfo) {
        userContactInfoService.postUserContactInfo(userContactInfo);
    }

    @DeleteMapping(path = "{userContactInfoId}")
    public void deleteUserContactInfo(@PathVariable("userContactInfoId") Long userContactInfoId){
        log.warn("user contact deleted");
        userContactInfoService.deleteUserContactInfo(userContactInfoId);
    }

}