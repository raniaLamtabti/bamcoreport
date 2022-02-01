package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.GroupDto;
import com.example.bamcoreport.entities.Group;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.services.Impl.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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

    @DeleteMapping(path = "{groupId}")
    public void deleteRole(@PathVariable("groupId") Long groupId){
        log.warn("group deleted");
        groupService.deleteGroup(groupId);
    }
}
