package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.RoleDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.entities.UserContactInfo;
import com.example.bamcoreport.repositories.RoleRepository;
import com.example.bamcoreport.services.Impl.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    IMapClassWithDto<Role, RoleDto> RoleMapping;

    @Override
    public List<RoleDto> getRoles() {
        List<Role> Roles = roleRepository.findAll();
        return RoleMapping.convertListToListDto(Roles,RoleDto.class);
    }

    @Override
    public void postRole(Role role) {
        roleRepository.save(role);
    }
}
