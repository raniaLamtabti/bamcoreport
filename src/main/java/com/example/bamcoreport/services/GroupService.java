package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.GroupDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.Group;
import com.example.bamcoreport.repositories.GroupRepository;
import com.example.bamcoreport.services.Impl.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

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

    @Override
    public void deleteGroup(Long groupId) {
        boolean exists =  groupRepository.existsById(groupId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        groupRepository.deleteById(groupId);
    }
}
