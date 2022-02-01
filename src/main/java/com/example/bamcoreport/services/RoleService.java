package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.RoleDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.entities.UserContactInfo;
import com.example.bamcoreport.repositories.RoleRepository;
import com.example.bamcoreport.services.Impl.IRoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

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

    @Override
    public void deleteRole(Long roleId) {
        boolean exists =  roleRepository.existsById(roleId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        roleRepository.deleteById(roleId);
    }
}
