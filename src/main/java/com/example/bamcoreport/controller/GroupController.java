package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.GroupDto;
import com.example.bamcoreport.entities.Group;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.services.Impl.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    IGroupService groupService;

    @GetMapping("/")
    public ResponseEntity<List<GroupDto>> getAllGroups(){
        List<GroupDto> GroupDto = groupService.getGroups();
        return ResponseEntity.ok(GroupDto);
    }

    @PostMapping
    public void postGroup(@RequestBody Group group) {
        groupService.postGroup(group);
    }
}
