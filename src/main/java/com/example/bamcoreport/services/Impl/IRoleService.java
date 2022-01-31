package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.RoleDto;
import com.example.bamcoreport.entities.Role;

import java.util.List;

public interface IRoleService {
    List<RoleDto> getRoles();
    void postRole(Role role);
}
