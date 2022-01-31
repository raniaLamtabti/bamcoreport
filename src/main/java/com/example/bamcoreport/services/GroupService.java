package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.GroupDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.Group;
import com.example.bamcoreport.repositories.GroupRepository;
import com.example.bamcoreport.services.Impl.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    IMapClassWithDto<Group, GroupDto> GroupMapping;

    @Override
    public List<GroupDto> getGroups()  {
        List<Group> Groups = groupRepository.findAll();
        return GroupMapping.convertListToListDto(Groups,GroupDto.class);
    }

    @Override
    public void postGroup(Group group) {
        groupRepository.save(group);
    }
}
