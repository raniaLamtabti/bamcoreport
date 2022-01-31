package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.GroupDto;
import com.example.bamcoreport.entities.Group;

import java.util.List;

public interface IGroupService {
    List<GroupDto> getGroups();
    void postGroup(Group group);
}
